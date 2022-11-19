/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendtechelevator;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Gbett
 */
public class LendtechElevator {

    public static ExecutorService requestExecutor = Executors.newFixedThreadPool(50);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8285), 50);

            server.createContext("/lendtechelevators/api", new RequestHandler("SAVE_NEW_STATE"));
            server.createContext("/lendtechelevators/position", new RequestHandler("GET_CURRENT_POSITION"));
            server.setExecutor(requestExecutor); // creates fixed pool of 50 threads
            server.start();
        } catch (Exception e) {

        }
    }

}
