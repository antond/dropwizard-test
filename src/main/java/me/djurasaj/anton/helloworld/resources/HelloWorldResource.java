package me.djurasaj.anton.helloworld.resources;

import me.djurasaj.anton.helloworld.core.Saying;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Path("/hello-world")
public class HelloWorldResource {
    private Saying oldSaying;
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldResource.class);

    public HelloWorldResource() {
        oldSaying = new Saying(111, "Hello, old test!");
    }

    @PUT
    @Timed
    @Produces(MediaType.APPLICATION_XML)
    public Saying update(Saying saying) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            LOGGER.info("Saying before the update: {}", mapper.writeValueAsString(oldSaying));
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Saying newSaying = oldSaying.update(saying);
        return newSaying;
    }
}