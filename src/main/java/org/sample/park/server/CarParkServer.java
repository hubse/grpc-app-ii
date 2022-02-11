package org.sample.park.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class CarParkServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        Server server = ServerBuilder.forPort(5003)
                .addService(new CarParkServiceImpl())
                .build();

        server.start();

        // Server is kept alive for the client to communicate.
        server.awaitTermination();
    }
}
