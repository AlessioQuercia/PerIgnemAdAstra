package beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

@XmlRootElement(name = "data")
public class Data
{
    @XmlElement(name = "reportsList")
    private List<Report> reportsList;

    @XmlElement(name = "firesList")
    private List<Fire> firesList;

    @XmlElement(name = "alertsList")
    private List<Alert> alertsList;

    private static Data instance;

    private Data()
    {
        reportsList = new ArrayList<Report>();

        firesList = new ArrayList<Fire>();

        alertsList = new ArrayList<Alert>();

    }

    public static synchronized Data getInstance()
    {
        if(instance == null)
        {
            instance = new Data();
        }
        return instance;
    }

    public List<Report> getReportsList()
    {
        ArrayList<Report> copy = null;

        synchronized (reportsList)
        {
            copy = new ArrayList<>(reportsList);
        }

        return copy;
    }

    public void addReport(Report report)
    {
        synchronized (reportsList)
        {
            reportsList.add(report);
            System.out.println(reportsList);
        }
    }

    @Override
    public String toString()
    {
        String result = "";

        synchronized (reportsList)
        {
            for (Report r: reportsList)
            {
                result += r + "/n";
            }
        }
        return result;
    }

}
