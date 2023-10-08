package com.funcmain.employeerestref;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/employees")
public class EmployeeController {
    EmployeeService employeeService = new EmployeeService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployees() {
        Logger.getLogger("GET/Employees").log(Level.ALL, "Received request to fetch all employees.");
        return Response.ok(employeeService.getAllEmployees()).build();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployee(@PathParam("id") Integer id) {
        Logger.getLogger("GET/Employees/id").log(Level.ALL, "Received request to fetch employee.");
        Optional<Employee> employee = Optional.ofNullable(employeeService.getEmployee(id));
        if (employee.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(employee).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createEmployee(Employee employee) {
        Logger.getLogger("POST/Employees").log(Level.ALL, "Received request to create employee.");
        Boolean success = employeeService.createEmployee(employee);
        if (success.equals(false))
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

        return Response.ok().build();
    }
}
