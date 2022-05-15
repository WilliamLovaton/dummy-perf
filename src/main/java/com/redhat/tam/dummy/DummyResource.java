package com.redhat.tam.dummy;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/dummy")
public class DummyResource {

    @Inject
    DummyService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String base() {
        return "Plese use any of these paths /dummy/fast, /dummy/slow-1, /dummy/slow-3, /dummy/slow-5 or /dummy/slow-10";
    }

    @GET
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/fast")
    public DummyResult fast() {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        return new DummyResult("You are calling the " + methodName + "() method", service.getCounter());
    }

    @GET
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/slow-1")
    public DummyResult slow_1() throws InterruptedException {
        Thread.sleep(1000);
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        return new DummyResult("You are calling the " + methodName + "() method", service.getCounter());
    }

    @GET
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/slow-3")
    public DummyResult slow_3() throws InterruptedException {
        Thread.sleep(3000);
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        return new DummyResult("You are calling the " + methodName + "() method", service.getCounter());
    }

    @GET
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/slow-5")
    public DummyResult slow_5() throws InterruptedException {
        Thread.sleep(5000);
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        return new DummyResult("You are calling the " + methodName + "() method", service.getCounter());
    }

    @GET
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/slow-10")
    public DummyResult slow_10() throws InterruptedException {
        Thread.sleep(10000);
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        return new DummyResult("You are calling the " + methodName + "() method", service.getCounter());
    }



    public static class DummyResult {
        private String message;
        private String hostname;
        private long counter;

        public DummyResult(String message, long counter) {
            this.message = message;
            this.hostname = System.getenv("HOSTNAME");
            this.counter = counter;
        }

        public String getMessage() {
            return message;
        }

        public String getHostname() {
            return hostname;
        }

        public long getCounter() {
            return counter;
        }
    }
}
