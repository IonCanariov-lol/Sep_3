using Microsoft.AspNetCore.Components.Authorization;
using System;
using System.Collections.Generic;
using System.Security.Claims;
using System.Text.Json;
using System.Threading.Tasks;
using BlazorApp1.Models.User;
using BlazorApp1.Services;
using Microsoft.AspNetCore.Components.Authorization;
using Microsoft.JSInterop;


namespace BlazorApplication.Authentication;

public class SystemAuthenticationStateProvider : AuthenticationStateProvider
{
    private readonly IJSRuntime jsRuntime;
    private readonly ILoginService loginService;
    private UserModel user;
    
    public SystemAuthenticationStateProvider(IJSRuntime jsRuntime, ILoginService loginService)
    {
        this.jsRuntime = jsRuntime;
        this.loginService = loginService;
    }
    public override async Task<AuthenticationState> GetAuthenticationStateAsync()
    {
        var identity = new ClaimsIdentity();
        if (user == null)
        {
            string userAsJson = await jsRuntime.InvokeAsync<string>("sessionStorage.getItem", "currentUser");
            if (!string.IsNullOrEmpty(userAsJson))
            {
                user = JsonSerializer.Deserialize<UserModel>(userAsJson);
                identity = SetupClaimsForUser(user);
            }
        }
        else
        {
            identity = SetupClaimsForUser(user);
        }

        ClaimsPrincipal cachedClaimsPrincipal = new ClaimsPrincipal(identity);
        return await Task.FromResult(new AuthenticationState(cachedClaimsPrincipal));    }
    
    public async Task ValidateLogin(string username, string password)
    {
        Console.WriteLine("Validating log in");
        if (string.IsNullOrEmpty(username)) throw new Exception("Please enter username");
        if (string.IsNullOrEmpty(password)) throw new Exception("Please enter password");

        ClaimsIdentity identity = new ClaimsIdentity();
            
        UserModel newUser = await loginService.ValidateAccountAsync(username, password);
        identity = SetupClaimsForUser(user);
        string serialisedData = JsonSerializer.Serialize(user);
        Console.WriteLine($"Serialized data: {serialisedData}");
        await jsRuntime.InvokeVoidAsync("sessionStorage.setItem", "currentUser", serialisedData);
        Console.WriteLine("after jsRuntime");
        user = newUser;

        NotifyAuthenticationStateChanged(Task.FromResult(new AuthenticationState(new ClaimsPrincipal(identity))));
    }
    
    public async Task Logout()
    {
        this.user = null;
        var user = new ClaimsPrincipal(new ClaimsIdentity());
        await jsRuntime.InvokeVoidAsync("sessionStorage.setItem", "currentUser", "");
        NotifyAuthenticationStateChanged(Task.FromResult(new AuthenticationState(user)));
    }

    private ClaimsIdentity SetupClaimsForUser(UserModel user)
    {
        List<Claim> claims = new List<Claim>();
        claims.Add(new Claim("Role",user.UserRole.RoleType));
        ClaimsIdentity identity = new ClaimsIdentity(claims, "apiauth_type");
        return identity;
    }
}
