package src.Interfaces;

import src.Models.Booking;

public interface IBookingDAO {
    void GetBookingByID(int id);
    void CreateBooking(Booking booking);
}
