using BlazorApp1.Models.User;

namespace BlazorApp1.Services;

public interface IregisterService
{
    Task RegisterUser(UserModel user);
}