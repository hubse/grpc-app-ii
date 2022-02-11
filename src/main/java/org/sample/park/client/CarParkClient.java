package org.sample.park.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.sample.park.CarParkServiceGrpc;
import org.sample.park.ParkRequest;
import org.sample.park.ParkResponse;
import org.sample.park.Vehicle;

public class CarParkClient {

    public static void main(String[] args) {

        // Channel is used by the client to communicate with the server.
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5003)
                .usePlaintext()
                .build();

        CarParkServiceGrpc.CarParkServiceBlockingStub stub =CarParkServiceGrpc.newBlockingStub(channel);

        ParkRequest parkRequest = ParkRequest.newBuilder()
                .setVehicle(Vehicle.newBuilder()
                        .setVehicleNumber("NA-1324")
                        .setVehicleType("BUS")
                        .build())
                .build();

        ParkResponse parkResponse = stub.parkVehicle(parkRequest);
        System.out.println("Response for the first call: " + parkResponse.getResult());

        System.out.println("### Initiating the second request ###");
        // Hold the thread for 10s before calling the other method.
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ParkRequest parkRequest2 = ParkRequest.newBuilder()
                .setVehicle(Vehicle.newBuilder()
                        .setVehicleNumber("PE-6723")
                        .setVehicleType("VAN")
                        .build())
                .build();

        System.out.println("Response for the second call: ");
        stub.parkVehicleManyTimes(parkRequest2).forEachRemaining(parkResponseManyTimes -> {
            System.out.println(parkResponseManyTimes.getResult());
        });
    }
}
