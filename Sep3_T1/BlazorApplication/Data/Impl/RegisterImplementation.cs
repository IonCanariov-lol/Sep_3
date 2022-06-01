using System.Text;
using System.Text.Json;
using BlazorApp1.Models.User;

namespace BlazorApp1.Services.Impl;

public class RegisterImplementation:IregisterService
{
    public async Task RegisterUser(UserModel user)
    {
        UserModel userModel = new UserModel
        {
            FirstName = user.FirstName,
            LastName = user.LastName,
            Username = user.Username,
            Password = user.Password,
            UserRole = user.UserRole,
        };
        HttpClient client = new HttpClient();
        string userSerialized = JsonSerializer.Serialize(userModel);
        StringContent content = new StringContent(
            userSerialized,
            Encoding.UTF8,
            "user/jason");
        HttpResponseMessage responseMessage =
            await client.PostAsync("http://localhost:8080/user/registerUser", content);
        int statusResponse = (int) responseMessage.StatusCode;
        if (statusResponse == 409)
        {
            throw new Exception("Username taken");
        }
     //   else if( statusResponse == )
     {
         throw new Exception();
     }

    }
}