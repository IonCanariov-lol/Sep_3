using System.ComponentModel.DataAnnotations;
using System.Diagnostics.CodeAnalysis;
using System.Text.Json.Serialization;

namespace BlazorApp1.Models.User;

public class UserModel
{
    
    public string FirstName { get; set; }
    public string LastName { get; set; }
    public Role UserRole { get; set; }
    [Required]
    [NotNull]
    [JsonPropertyName("Username")]
    public string Username { get; set; }
    
    [Required]
    [JsonPropertyName("Password")]
    [MinLength(8, ErrorMessage = "Password is too short")]
    public string Password { get; set; }
}