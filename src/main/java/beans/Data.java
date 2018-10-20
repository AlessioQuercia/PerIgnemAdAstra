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

    public List<Fire> getFiresList()
    {
        ArrayList<Fire> copy = null;

        synchronized (firesList)
        {
            copy = new ArrayList<>(firesList);
        }

        return copy;
    }

    public List<Alert> getAlertsList()
    {
        ArrayList<Alert> copy = null;

        synchronized (alertsList)
        {
            copy = new ArrayList<>(alertsList);
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

    public void addFire(Fire fire)
    {
        synchronized (firesList)
        {
            firesList.add(fire);
            System.out.println(firesList);
        }
    }

    public void addAlert(Alert alert)
    {
        synchronized (alertsList)
        {
            alertsList.add(alert);
            System.out.println(alertsList);
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

    public Report getReportById(int id)
    {
        Report report = null;
        synchronized (reportsList)
        {
            for (Report r : reportsList)
            {
                if (r.getId() == id)
                    report = r;
            }
        }
        return report;
    }
}
