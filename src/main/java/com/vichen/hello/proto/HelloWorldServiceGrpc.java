package com.vichen.hello.proto;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 *声明服务，HelloWorldService为Java文件名称，内部会生成几个类
 **BlockingStub：client基本数据调用
 **Stub：client端流数据调用
 **ImplBase：server端抽象类
 **FutureStub：
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: helloWorld.proto")
public final class HelloWorldServiceGrpc {

  private HelloWorldServiceGrpc() {}

  public static final String SERVICE_NAME = "com.vichen.hello.proto.HelloWorldService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.vichen.hello.proto.HelloWorld.Request,
      com.vichen.hello.proto.HelloWorld.Response> METHOD_SAY_HELLO =
      io.grpc.MethodDescriptor.<com.vichen.hello.proto.HelloWorld.Request, com.vichen.hello.proto.HelloWorld.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.vichen.hello.proto.HelloWorldService", "sayHello"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.vichen.hello.proto.HelloWorld.Request.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.vichen.hello.proto.HelloWorld.Response.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.vichen.hello.proto.HelloWorld.Request,
      com.vichen.hello.proto.HelloWorld.Response> METHOD_SAY_HELLO_STREAM_RESPONSE =
      io.grpc.MethodDescriptor.<com.vichen.hello.proto.HelloWorld.Request, com.vichen.hello.proto.HelloWorld.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "com.vichen.hello.proto.HelloWorldService", "sayHelloStreamResponse"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.vichen.hello.proto.HelloWorld.Request.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.vichen.hello.proto.HelloWorld.Response.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.vichen.hello.proto.HelloWorld.Request,
      com.vichen.hello.proto.HelloWorld.Response> METHOD_SAY_HELLO_STREAM_REQUEST =
      io.grpc.MethodDescriptor.<com.vichen.hello.proto.HelloWorld.Request, com.vichen.hello.proto.HelloWorld.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "com.vichen.hello.proto.HelloWorldService", "sayHelloStreamRequest"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.vichen.hello.proto.HelloWorld.Request.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.vichen.hello.proto.HelloWorld.Response.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.vichen.hello.proto.HelloWorld.Request,
      com.vichen.hello.proto.HelloWorld.Response> METHOD_CHAT_HELLO =
      io.grpc.MethodDescriptor.<com.vichen.hello.proto.HelloWorld.Request, com.vichen.hello.proto.HelloWorld.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "com.vichen.hello.proto.HelloWorldService", "chatHello"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.vichen.hello.proto.HelloWorld.Request.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.vichen.hello.proto.HelloWorld.Response.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HelloWorldServiceStub newStub(io.grpc.Channel channel) {
    return new HelloWorldServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HelloWorldServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HelloWorldServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HelloWorldServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HelloWorldServiceFutureStub(channel);
  }

  /**
   * <pre>
   *声明服务，HelloWorldService为Java文件名称，内部会生成几个类
   **BlockingStub：client基本数据调用
   **Stub：client端流数据调用
   **ImplBase：server端抽象类
   **FutureStub：
   * </pre>
   */
  public static abstract class HelloWorldServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sayHello(com.vichen.hello.proto.HelloWorld.Request request,
        io.grpc.stub.StreamObserver<com.vichen.hello.proto.HelloWorld.Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SAY_HELLO, responseObserver);
    }

    /**
     */
    public void sayHelloStreamResponse(com.vichen.hello.proto.HelloWorld.Request request,
        io.grpc.stub.StreamObserver<com.vichen.hello.proto.HelloWorld.Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SAY_HELLO_STREAM_RESPONSE, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.vichen.hello.proto.HelloWorld.Request> sayHelloStreamRequest(
        io.grpc.stub.StreamObserver<com.vichen.hello.proto.HelloWorld.Response> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_SAY_HELLO_STREAM_REQUEST, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.vichen.hello.proto.HelloWorld.Request> chatHello(
        io.grpc.stub.StreamObserver<com.vichen.hello.proto.HelloWorld.Response> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_CHAT_HELLO, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SAY_HELLO,
            asyncUnaryCall(
              new MethodHandlers<
                com.vichen.hello.proto.HelloWorld.Request,
                com.vichen.hello.proto.HelloWorld.Response>(
                  this, METHODID_SAY_HELLO)))
          .addMethod(
            METHOD_SAY_HELLO_STREAM_RESPONSE,
            asyncServerStreamingCall(
              new MethodHandlers<
                com.vichen.hello.proto.HelloWorld.Request,
                com.vichen.hello.proto.HelloWorld.Response>(
                  this, METHODID_SAY_HELLO_STREAM_RESPONSE)))
          .addMethod(
            METHOD_SAY_HELLO_STREAM_REQUEST,
            asyncClientStreamingCall(
              new MethodHandlers<
                com.vichen.hello.proto.HelloWorld.Request,
                com.vichen.hello.proto.HelloWorld.Response>(
                  this, METHODID_SAY_HELLO_STREAM_REQUEST)))
          .addMethod(
            METHOD_CHAT_HELLO,
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.vichen.hello.proto.HelloWorld.Request,
                com.vichen.hello.proto.HelloWorld.Response>(
                  this, METHODID_CHAT_HELLO)))
          .build();
    }
  }

  /**
   * <pre>
   *声明服务，HelloWorldService为Java文件名称，内部会生成几个类
   **BlockingStub：client基本数据调用
   **Stub：client端流数据调用
   **ImplBase：server端抽象类
   **FutureStub：
   * </pre>
   */
  public static final class HelloWorldServiceStub extends io.grpc.stub.AbstractStub<HelloWorldServiceStub> {
    private HelloWorldServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloWorldServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloWorldServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloWorldServiceStub(channel, callOptions);
    }

    /**
     */
    public void sayHello(com.vichen.hello.proto.HelloWorld.Request request,
        io.grpc.stub.StreamObserver<com.vichen.hello.proto.HelloWorld.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SAY_HELLO, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sayHelloStreamResponse(com.vichen.hello.proto.HelloWorld.Request request,
        io.grpc.stub.StreamObserver<com.vichen.hello.proto.HelloWorld.Response> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_SAY_HELLO_STREAM_RESPONSE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.vichen.hello.proto.HelloWorld.Request> sayHelloStreamRequest(
        io.grpc.stub.StreamObserver<com.vichen.hello.proto.HelloWorld.Response> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_SAY_HELLO_STREAM_REQUEST, getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.vichen.hello.proto.HelloWorld.Request> chatHello(
        io.grpc.stub.StreamObserver<com.vichen.hello.proto.HelloWorld.Response> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_CHAT_HELLO, getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *声明服务，HelloWorldService为Java文件名称，内部会生成几个类
   **BlockingStub：client基本数据调用
   **Stub：client端流数据调用
   **ImplBase：server端抽象类
   **FutureStub：
   * </pre>
   */
  public static final class HelloWorldServiceBlockingStub extends io.grpc.stub.AbstractStub<HelloWorldServiceBlockingStub> {
    private HelloWorldServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloWorldServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloWorldServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloWorldServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.vichen.hello.proto.HelloWorld.Response sayHello(com.vichen.hello.proto.HelloWorld.Request request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SAY_HELLO, getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.vichen.hello.proto.HelloWorld.Response> sayHelloStreamResponse(
        com.vichen.hello.proto.HelloWorld.Request request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_SAY_HELLO_STREAM_RESPONSE, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *声明服务，HelloWorldService为Java文件名称，内部会生成几个类
   **BlockingStub：client基本数据调用
   **Stub：client端流数据调用
   **ImplBase：server端抽象类
   **FutureStub：
   * </pre>
   */
  public static final class HelloWorldServiceFutureStub extends io.grpc.stub.AbstractStub<HelloWorldServiceFutureStub> {
    private HelloWorldServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloWorldServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloWorldServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloWorldServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.vichen.hello.proto.HelloWorld.Response> sayHello(
        com.vichen.hello.proto.HelloWorld.Request request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SAY_HELLO, getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;
  private static final int METHODID_SAY_HELLO_STREAM_RESPONSE = 1;
  private static final int METHODID_SAY_HELLO_STREAM_REQUEST = 2;
  private static final int METHODID_CHAT_HELLO = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HelloWorldServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HelloWorldServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((com.vichen.hello.proto.HelloWorld.Request) request,
              (io.grpc.stub.StreamObserver<com.vichen.hello.proto.HelloWorld.Response>) responseObserver);
          break;
        case METHODID_SAY_HELLO_STREAM_RESPONSE:
          serviceImpl.sayHelloStreamResponse((com.vichen.hello.proto.HelloWorld.Request) request,
              (io.grpc.stub.StreamObserver<com.vichen.hello.proto.HelloWorld.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO_STREAM_REQUEST:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sayHelloStreamRequest(
              (io.grpc.stub.StreamObserver<com.vichen.hello.proto.HelloWorld.Response>) responseObserver);
        case METHODID_CHAT_HELLO:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.chatHello(
              (io.grpc.stub.StreamObserver<com.vichen.hello.proto.HelloWorld.Response>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class HelloWorldServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.vichen.hello.proto.HelloWorld.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HelloWorldServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HelloWorldServiceDescriptorSupplier())
              .addMethod(METHOD_SAY_HELLO)
              .addMethod(METHOD_SAY_HELLO_STREAM_RESPONSE)
              .addMethod(METHOD_SAY_HELLO_STREAM_REQUEST)
              .addMethod(METHOD_CHAT_HELLO)
              .build();
        }
      }
    }
    return result;
  }
}
