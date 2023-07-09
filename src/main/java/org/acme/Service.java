package org.acme;


import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;
import io.quarkus.custom.proto.GetUserReply;
import io.quarkus.custom.proto.GetUserRequest;
import io.quarkus.custom.proto.UserService;

@GrpcService
public class Service implements UserService {
    @Override
    public Uni<GetUserReply> getUser(GetUserRequest request) {
        switch (request.getUserId()) {
            case "1":
                return Uni.createFrom().item(() -> GetUserReply.newBuilder()
                        .setUserName("Thomas").setUserEmail("thomas@mail.com")
                        .setUserNickname("tom").setUserRole("Admin").build());

            case "2":
                return Uni.createFrom().item(() -> GetUserReply.newBuilder()
                        .setUserName("James").setUserEmail("james@mail.com")
                        .setUserNickname("jam").setUserRole("Manager").build());
            case "3":
                return Uni.createFrom().item(() -> GetUserReply.newBuilder()
                        .setUserName("Andrew").setUserEmail("andrew@mail.com")
                        .setUserNickname("andy").setUserRole("engineer").build());
            default:
                throw new RuntimeException("");
        }
    }
}
