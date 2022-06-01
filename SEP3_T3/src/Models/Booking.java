package src.Models;

public class Booking {
    private String StartDate;
    private String EndDate;
    private String Username;

    public Booking(String startDate, String endDate, String username) {
        StartDate = startDate;
        EndDate = endDate;
        Username = username;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
