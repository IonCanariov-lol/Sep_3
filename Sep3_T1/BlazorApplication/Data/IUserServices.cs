using BlazorApp1.Models.User;

namespace BlazorApp1.Services;

public interface IUserServices
{
    Task UpdateUser();
    Task<UserModel> GetAllUsers();
    Task GetUserByUsername(string username);
}