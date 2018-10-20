package beans;

public class Fire
{
    private int id;
    private double latitude;
    private double longitude;
    private String description;
//    private FireStatus status;
//    private DangerStatus danger;
    private double radius;

    public Fire(int id, double latitude, double longitude, double radius)
    {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }
}
