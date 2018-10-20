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



//    //get the fire list
//    @GET
//    @Produces({"application/json", "application/xml"})
//    public Response getFire(){
//
////        City.getInstance().toString();
////        System.out.println(City.getInstance().getNodesList().toString());
//        return Response.ok(Data.getInstance().getFiresList()).build();
//
//    }
//
//
//    //get the alerts list
//    @GET
//    @Produces({"application/json", "application/xml"})
//    public Response getAlerts(){
//
////        City.getInstance().toString();
////        System.out.println(City.getInstance().getNodesList().toString());
//        return Response.ok(Data.getInstance().getAlertsList()).build();
//
//    }


    //It allows to add a new Node to the city grid (and to the list of nodes)
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


//    //It allows to add a new Node to the city grid (and to the list of nodes)
//    @Path("add")
//    @POST
//    @Consumes({"application/json", "application/xml"})
//    public Response addFuoco(Fire fire)
//    {
//
//        return Response.ok().build();
//    }
//
//
//    //It allows to add a new Node to the city grid (and to the list of nodes)
//    @Path("add")
//    @POST
//    @Consumes({"application/json", "application/xml"})
//    public Response addAlert(Alert alert)
//    {
//
//        return Response.ok().build();
//    }
//
//
//    //Update report (changing its status)
//    @Path("update")
//    @PUT
//    @Consumes({"application/json", "application/xml"})
//    public Response updateReport(Report report)
//    {
//
//        return Response.ok().build();
//    }
}
