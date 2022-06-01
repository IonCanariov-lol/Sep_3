package src.Interfaces;

import src.Models.User;

public interface IUserDAO {
    void GetUserByUsername(String username);
    void GetAllUsers();

    void UpdateCustomerByUser(String oldUsername, User newCustomer);
}
