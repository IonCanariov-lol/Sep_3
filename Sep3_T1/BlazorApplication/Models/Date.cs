namespace BlazorApp1.Models;

public class Date
{
    public int Day;
    public int Month;
    public int Year;

    public Date(int day, int month, int year)
    {
        this.Day = day;
        this.Month = month;
        this.Year = year;
    }

    public Boolean IsBeforeDate(Date date)
    {
        if (this.Day > date.Day || this.Month > date.Month || this.Year > date.Year){}
   
        return true;
    }
}
    