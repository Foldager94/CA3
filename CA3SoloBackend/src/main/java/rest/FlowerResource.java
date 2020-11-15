/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.FlowerDTO;
import entities.Flowers;
import facades.FlowerFacade;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author ckfol
 */
@Path("flower")
public class FlowerResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final FlowerFacade FACADE = FlowerFacade.getFlowerFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    /**
     * Creates a new instance of FlowerResource
     */
    public FlowerResource() {
    }

    /**
     * Retrieves representation of an instance of rest.FlowerResource
     * @param username
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{username}")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserFlower(@PathParam("username") String username){
        FlowerDTO flower = FACADE.getUserFlower(username);
        return GSON.toJson(flower);
    }
}
