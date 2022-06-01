package src;

import src.DAOs.UserDAO;
import src.Models.User;

public class TestClass {
    public static void main(String[] args) {
//        BookingDAO bookingDAO = new BookingDAO();
//        RegisterDAO registerDAO = new RegisterDAO();
        User customer = new User("ciorap", "petrisor", "ciorapisor", "ceeparola", "client");
        UserDAO userDAO = new UserDAO();
//        ManageLoginDAO manageLoginDAO = new ManageLoginDAO();
//        Booking booking = new Booking("01-12-2022", "02-12-2022", "user");

//        bookingDAO.GetBookingByID(201);
//        registerDAO.Register(customer);
//        userDAO.GetUserByUsername("cevaporecla");
//        userDAO.GetAllUsers();
//        manageLoginDAO.Login("betesig", "parola");
//        bookingDAO.CreateBooking(booking);
        userDAO.UpdateCustomerByUser("betesig", customer);
    }
}
