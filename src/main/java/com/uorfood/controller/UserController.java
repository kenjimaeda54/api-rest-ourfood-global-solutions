package com.uorfood.controller;

import com.uorfood.domain.Users;
import com.uorfood.service.UserService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.sql.SQLException;
import java.util.List;


@Path("/users")
public class UserController {
        UserService service = new UserService();


        public UserController() throws SQLException {
        }

        @GET
        @Produces("application/json")
        public List<Users> getAllUsers() {
            return  service.getAllUsers();
        }

        @POST
        @Produces("application/json")
        public Response insertUsers(Users user, @Context UriInfo uri) {
            service.insertUsers(user);
            UriBuilder builder = uri.getAbsolutePathBuilder();
            builder.path(Integer.toString(user.getId()));
            return Response.accepted().build();
        }


}
