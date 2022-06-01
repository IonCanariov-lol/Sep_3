using System;
using System.Net.Http;
using System.Text.Json;
using System.Threading.Tasks;
using BlazorApp1.Hashing;
using BlazorApp1.Models.User;
using BlazorApp1.Pages;

namespace BlazorApp1.Services.Impl;

public class LoginImplementation: ILoginService
{
    public async Task<UserModel> ValidateAccountAsync(string username, string password)
    {
        Console.WriteLine($"{username} + {password}");
        string hash = HashPassword.GetHashPassword(password);
        Console.WriteLine($"HASHED --- {hash}");
        HttpClient client = new HttpClient();

        HttpResponseMessage response =
            await client.GetAsync($"http://localhost:8080/login?username={username}&password={hash}");

        if (!response.IsSuccessStatusCode)
        {
            throw new Exception($"{response.Content.ReadAsStringAsync().Result}");
        }
            
        string result = await response.Content.ReadAsStringAsync();
        Console.WriteLine($"result before deserialization: {result}");
        UserModel user = ToObject<UserModel>(result);
        Console.WriteLine($"User received: {user}");
        return user;
    }
    private T ToObject<T>(String element)
    {
        var deserializeResult = JsonSerializer.Deserialize<T>(element, new JsonSerializerOptions()
        {
            PropertyNameCaseInsensitive = true
        });
        return deserializeResult;
    }
}