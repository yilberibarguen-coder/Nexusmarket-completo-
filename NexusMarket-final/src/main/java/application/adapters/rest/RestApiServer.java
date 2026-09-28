package application.adapters.rest;

import application.NexusMarketApplication;
import application.adapters.rest.controllers.HealthRestController;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

/** Optional JDK HTTP entry point for local demonstrations. */
public final class RestApiServer implements AutoCloseable {
    private final HttpServer server;
    private final HealthRestController health=new HealthRestController();
    public RestApiServer(NexusMarketApplication application,int port) throws IOException {
        server=HttpServer.create(new InetSocketAddress(port),0);
        server.createContext("/api/v1/health",this::health);
        server.createContext("/api/v1",this::notFound);
    }
    public void start(){server.start();}
    private void health(HttpExchange exchange) throws IOException {if(!"GET".equalsIgnoreCase(exchange.getRequestMethod())){send(exchange,405,"{\"error\":\"Method Not Allowed\"}");return;}send(exchange,200,health.health());}
    private void notFound(HttpExchange exchange) throws IOException {send(exchange,404,"{\"error\":\"Endpoint not implemented in the framework-free demo server\"}");}
    private static void send(HttpExchange e,int status,String body)throws IOException{byte[] b=body.getBytes(StandardCharsets.UTF_8);e.getResponseHeaders().set("Content-Type","application/json; charset=UTF-8");e.sendResponseHeaders(status,b.length);try(var out=e.getResponseBody()){out.write(b);}}
    @Override public void close(){server.stop(0);}
}
