namespace BlazorApp1.Hashing;
using System;
using System.Security.Cryptography;
using System.Text;

public class HashPassword
{
    public static string GetHashPassword(string input)
        {
            using SHA256 hashAlgorithm = SHA256.Create();
            byte[] data = hashAlgorithm.ComputeHash(Encoding.UTF8.GetBytes(input));

            var sBuilder = new StringBuilder();

            for (int i = 0; i < data.Length; i++)
            {
                sBuilder.Append(data[i].ToString("x2"));
            }

            return sBuilder.ToString();
        }

}