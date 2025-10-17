# grpc-sample
Sample gRPC App (Client-Server)

This is a simple gRPC-based application demonstrating communication between a client and a server using protocol buffers (Protobuf). The server implements a defined service with one or more RPC methods, and the client invokes these methods remotely over HTTP/2.

Server: Hosts the gRPC service, handles incoming RPC requests, and sends responses. It listens on a specified port and implements the logic defined in the .proto file.

Client: Connects to the gRPC server, sends requests, and receives responses. It uses the same .proto definitions to ensure consistent message structures.

The app showcases core gRPC features such as:

Remote method invocation

Protocol Buffers for message serialization

Strongly typed contracts between client and server

Simple unary or streaming communication (depending on implementation)

This app is ideal for learning or demonstrating how gRPC works in a microservices or distributed systems context.
