package beans;

public class Alert
{
    private int id;
    private double latitude;
    private double longitude;
    private String description;
    private double radius;

    public Alert(int id, double latitude, double longitude, double radius)
    {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }
}
