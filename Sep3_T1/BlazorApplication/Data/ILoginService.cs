using BlazorApp1.Models.User;
using BlazorApp1.Pages;

namespace BlazorApp1.Services;

public interface ILoginService
{
    Task<UserModel> ValidateAccountAsync(string username, string password);

}