using BlazorApp1.Models;

namespace BlazorApp1.Services;

public interface IBookingServices
{
    Task CreateBooking();
    Task DeleteBooking();
    Task<Booking> GetAllBookings();
    Task SearchBokingByUser();
}