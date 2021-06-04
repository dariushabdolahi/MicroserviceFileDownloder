package service;

import common.FileManager;
import common.RamDB;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.nio.file.Files;
import java.nio.file.Paths;

@Path("api")
public class Api {

    @Path("download")
    @GET
    public Response download(@QueryParam("key") String key) {
        if (FileManager.getInstance().isTokenValid(key)) {
            StreamingOutput fileStream = new StreamingOutput() {
                @Override
                public void write(java.io.OutputStream output) {
                    java.nio.file.Path path = Paths.get(FileManager.getInstance().getPath());
                    byte[] data ;
                    try {
                        data = Files.readAllBytes(path);
                        output.write(data);
                        output.flush();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            return Response
                    .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                    .header("content-disposition", "attachment; filename = " + FileManager.getInstance().getFileName())
                    .build();
        } else {
            return Response.serverError().build();
        }
    }

}
