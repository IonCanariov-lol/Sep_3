using BlazorApp1.Models.User;
using Microsoft.VisualBasic;

namespace BlazorApp1.Models;

public class Booking
{
    
    public Date StartDate { get; set; }
    public Date EndDate { get; set; }
    public UserModel Customer { get; set; }
    public Room Room { get; set; }

    public Booking(Date startDate,Date endDate,UserModel customer,Room room)
    {
        this.StartDate = startDate;
        this.EndDate = endDate;
        this.Customer = customer;
        this.Room = room;
    }

}