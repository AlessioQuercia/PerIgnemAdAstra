package beans;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.sql.Timestamp;

@XmlRootElement(name = "report")
public class Report
{
    private int id;
    private long time;
    private double latitude;
    private double longitude;
    private ReportStatus status;
    private ReportDanger danger;
    private File photo;
    private String description;


    public Report(int id, long time, double latitude, double longitude, ReportDanger danger)
    {
        this.id = id;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = ReportStatus.PENDING;
        this.danger = danger;
    }

    public Report(int id, long time, double latitude, double longitude, ReportDanger danger, File photo)
    {
        this.id = id;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = ReportStatus.PENDING;
        this.danger = danger;
        this.photo = photo;
    }

    public Report(int id, long time, double latitude, double longitude, ReportDanger danger, String description)
    {
        this.id = id;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = ReportStatus.PENDING;
        this.danger = danger;
        this.description = description;
    }

    public Report(int id, long time, double latitude, double longitude, ReportDanger danger, File photo, String description)
    {
        this.id = id;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = ReportStatus.PENDING;
        this.danger = danger;
        this.photo = photo;
        this.description = description;
    }

    @Override
    public String toString()
    {
        String result = "";

        result = id + " " + time + " " + latitude + " " + longitude + " " + status + " " + danger;

        return result;
    }
}
