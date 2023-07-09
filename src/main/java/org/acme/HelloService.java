package org.acme;

import io.quarkus.custom.proto.HelloReply;
import io.quarkus.custom.proto.HelloRequest;
import io.quarkus.grpc.GrpcService;
import io.quarkus.custom.proto.Greeter;
import io.smallrye.mutiny.Uni;

@GrpcService
public class HelloService implements Greeter {
    @Override
    public Uni<HelloReply> sayHello(HelloRequest request) {
        return Uni.createFrom().item(() -> HelloReply.newBuilder().setMessage("Hello" + request.getName()).build());
    }
}
