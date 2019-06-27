package com.vichen.hello.server;

import com.vichen.hello.proto.HelloWorld;
import com.vichen.hello.proto.HelloWorldServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author vichen
 */
public class HelloWorldImpl extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {
  private static final Logger logger = Logger.getLogger(HelloWorldImpl.class.getName());

  /**
   * 基础数据方法实现
   * @param request 请求参数
   * @param responseObserver 返回数据
   */
  @Override public void sayHello(HelloWorld.Request request,
    io.grpc.stub.StreamObserver<HelloWorld.Response> responseObserver) {
    HelloWorld.Response response =
      HelloWorld.Response.newBuilder().setData("Hello: " + request.getName()).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  /**
   * 返回流数据方法实现
   * @param request 请求参数
   * @param responseObserver 返回的流数据
   */
  @Override public void sayHelloStreamResponse(HelloWorld.Request request,
    StreamObserver<HelloWorld.Response> responseObserver) {
    for (int i = 0; i < 10; i++) {
      HelloWorld.Response response =
        HelloWorld.Response.newBuilder().setData("Hello: " + request.getName() + i).build();
      responseObserver.onNext(response);
    }
    responseObserver.onCompleted();
  }

  /**
   * 请求流数据方法实现
   * @param responseObserver 返回的数据
   * @return 请求的流数据
   */
  @Override public StreamObserver<HelloWorld.Request> sayHelloStreamRequest(
    StreamObserver<HelloWorld.Response> responseObserver) {
    return new StreamObserver<HelloWorld.Request>() {
      int count = 0;

      @Override public void onNext(HelloWorld.Request value) {
        logger.log(Level.INFO, "sayHelloStreamRequest onNext" + value.getName());
        count++;
      }

      @Override public void onError(Throwable t) {
        logger.log(Level.WARNING, "Encountered error in sayHelloStreamRequest", t);
      }

      @Override public void onCompleted() {
        logger.log(Level.INFO, "sayHelloStreamRequest onCompleted");
        responseObserver.onNext(HelloWorld.Response.newBuilder().setData("" + count).build());
        responseObserver.onCompleted();
      }
    };
  }

  /**
   * 双向流方法是爱你
   * @param responseObserver 返回的流数据
   * @return 请求的流数据
   */
  @Override public StreamObserver<HelloWorld.Request> chatHello(
    StreamObserver<HelloWorld.Response> responseObserver) {
    return new StreamObserver<HelloWorld.Request>() {

      @Override public void onNext(HelloWorld.Request value) {
        logger.log(Level.INFO, "chatHello onNext" + value.getName());
        responseObserver.onNext(HelloWorld.Response.newBuilder()
          .setData(String.valueOf(Integer.parseInt(value.getName()) + 1)).build());
      }

      @Override public void onError(Throwable t) {
        logger.log(Level.WARNING, "Encountered error in chatHello", t);
      }

      @Override public void onCompleted() {
        logger.log(Level.INFO, "chatHello onCompleted");
        responseObserver.onCompleted();
      }
    };
  }
}
