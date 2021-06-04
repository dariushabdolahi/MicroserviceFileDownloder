package controller;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;
import common.FileManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerConfigImp implements ServerConfig {

    private static final ServerConfigImp serverConfigImp = new ServerConfigImp();
    private HttpServer server;

    private ServerConfigImp() {
    }

    public static ServerConfigImp getInstance() {
        return serverConfigImp;
    }

    @Override
    public void start(String serverAddress) {
        try {
            ResourceConfig config = new PackagesResourceConfig("service");
            ExecutorService service = Executors.newFixedThreadPool(100);
            server = HttpServerFactory.create("http://"+serverAddress+"/", config);
            server.setExecutor(service);
            server.start();
            System.out.println("Server running");
            System.out.println("Visit: http://" + serverAddress + "/api/download?key=");
        } catch (Exception e) {
            System.out.println("Could not start server");
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        System.out.println("Stopping server");
        server.stop(0);
        System.out.println("Server stopped");
    }
}
