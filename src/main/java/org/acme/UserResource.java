package org.acme;


import io.quarkus.grpc.GrpcClient;
import io.smallrye.mutiny.Uni;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import io.quarkus.custom.proto.GetUserReply;
import io.quarkus.custom.proto.GetUserRequest;
import  io.quarkus.custom.proto.UserService;
@Path("/user")
public class UserResource {

    @GrpcClient
    UserService userService;

    @GET
    @Path("/{id}")
    public Uni<GetUserReply> getUser(String id) {
        return userService.getUser(GetUserRequest.newBuilder().setUserId(id).build());
    }
}