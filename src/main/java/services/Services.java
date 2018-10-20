package services;

import beans.*;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Path("services")
public class Services
{
    // get the reports list
    @Path("getReports")
    @GET
    @Produces({"application/json", "application/xml"})
    public Response getReports(){

        List<Report> reportsList = Data.getInstance().getReportsList();

        System.out.println(reportsList);

        Gson json = new Gson();

        return Response.ok(json.toJson(reportsList)).header("Access-Control-Allow-Origin", "*").build();
    }



    //get the fire list
    @GET
    @Produces({"application/json", "application/xml"})
    public Response getFire(){

        List<Fire> firesList = Data.getInstance().getFiresList();

        System.out.println(firesList);

        Gson json = new Gson();

        return Response.ok(json.toJson(firesList)).header("Access-Control-Allow-Origin", "*").build();
    }


    //get the alerts list
    @GET
    @Produces({"application/json", "application/xml"})
    public Response getAlerts(){

        List<Alert> alertsList = Data.getInstance().getAlertsList();

        System.out.println(alertsList);

        Gson json = new Gson();

        return Response.ok(json.toJson(alertsList)).header("Access-Control-Allow-Origin", "*").build();
    }


    @Path("addReport/{time}/{latitude}/{longitude}/{danger}")
    @POST
    @Produces({"application/json", "application/xml"})
    public Response addReport(@PathParam("time") long time, @PathParam("latitude") double latitude,
                              @PathParam("longitude") double longitude, @PathParam("danger") ReportDanger danger)
    {
        int id = new Random().nextInt();
        Report report = new Report(id, time, latitude, longitude, danger);
        Data.getInstance().addReport(report);

        System.out.println(report);

        return Response.ok().header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                .build();
    }


    @Path("addRFire/{latitude}/{longitude}/{radius}")
    @POST
    @Produces({"application/json", "application/xml"})
    public Response addFire(@PathParam("latitude") double latitude,
                              @PathParam("longitude") double longitude, @PathParam("radius") double radius)
    {
        int id = new Random().nextInt();
        Fire fire = new Fire(id, latitude, longitude, radius);
        Data.getInstance().addFire(fire);

        System.out.println(fire);

        return Response.ok().header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                .build();
    }



    @Path("addRFire/{latitude}/{longitude}/{radius}")
    @POST
    @Produces({"application/json", "application/xml"})
    public Response addAlert(@PathParam("latitude") double latitude,
                            @PathParam("longitude") double longitude, @PathParam("radius") double radius)
    {
        int id = new Random().nextInt();
        Alert alert = new Alert(id, latitude, longitude, radius);
        Data.getInstance().addAlert(alert);

        System.out.println(alert);

        return Response.ok().header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                .build();
    }


    //Update report (changing its status)
    @Path("updateReport/{id}/{status}")
    @PUT
    @Consumes({"application/json", "application/xml"})
    public Response updateReport(@PathParam("id") int id, @PathParam("status") ReportStatus status)
    {

        Report report = Data.getInstance().getReportById(id);

        if (report != null)
            report.setStatus(status);

        return Response.ok().build();
    }
}
