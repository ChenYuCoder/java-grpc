package com.vichen.hello.client;

import com.google.common.util.concurrent.SettableFuture;
import com.vichen.hello.proto.HelloWorld;
import com.vichen.hello.proto.HelloWorldServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author vichen
 */
public class HelloWorldClient {
  private static final Logger logger = Logger.getLogger(HelloWorldClient.class.getName());

  private final ManagedChannel channel;
  private final HelloWorldServiceGrpc.HelloWorldServiceBlockingStub blockingStub;
  private final HelloWorldServiceGrpc.HelloWorldServiceStub asyncStub;

  /**
   * Construct client connecting to HelloWorld server at {@code host:port}.
   */
  public HelloWorldClient(String host, int port) {
    this(ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build());
  }

  /**
   * Construct client for accessing HelloWorld server using the existing channel.
   */
  HelloWorldClient(ManagedChannel channel) {
    this.channel = channel;
    blockingStub = HelloWorldServiceGrpc.newBlockingStub(channel);
    asyncStub = HelloWorldServiceGrpc.newStub(channel);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  /**
   * 基本方法调用
   * @param name 名称
   */
  public void sayHello(String name) {
    HelloWorld.Request request = HelloWorld.Request.newBuilder().setName(name).build();
    HelloWorld.Response response;
    try {
      response = blockingStub.sayHello(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return;
    }
    logger.info("response : " + response.getData());
  }

  /**
   * 返回值为流数据的方法调用
   * @param name 名称
   */
  private void sayHelloStreamResponse(String name) {
    HelloWorld.Request request = HelloWorld.Request.newBuilder().setName(name).build();
    Iterator<HelloWorld.Response> responses;
    try {
      responses = blockingStub.sayHelloStreamResponse(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return;
    }
    while (responses.hasNext()) {
      logger.info("response : " + responses.next().getData());
    }
  }

  /**
   * 请求为流数据的方法调用
   */
  private void sayHelloStreamRequest() {
    final SettableFuture<Void> finishFuture = SettableFuture.create();
    StreamObserver<HelloWorld.Response> responseObserver =
      new StreamObserver<HelloWorld.Response>() {

        @Override public void onNext(HelloWorld.Response value) {
          logger.log(Level.INFO, "sayHelloStreamRequest onNext" + value.getData());
        }

        @Override public void onError(Throwable t) {
          //将异常写入流中，
          finishFuture.setException(t);
        }

        @Override public void onCompleted() {
          //标记入参结束，如果不设置则会导致该方法无法结束
          finishFuture.set(null);
        }
      };

    StreamObserver<HelloWorld.Request> requestObserver =
      asyncStub.sayHelloStreamRequest(responseObserver);
    try {
      for (int i = 0; i < 10; ++i) {
        HelloWorld.Request request = HelloWorld.Request.newBuilder().setName("" + i).build();
        requestObserver.onNext(request);
        if (finishFuture.isDone()) {
          break;
        }
      }
      requestObserver.onCompleted();

      finishFuture.get();
    } catch (Exception e) {
      requestObserver.onError(e);
      logger.log(Level.WARNING, "RecordRoute Failed", e);
    }

  }

  /**
   * 双向流方法调用
   */

  private void chatHello() {

    final SettableFuture<Void> finishFuture = SettableFuture.create();
    StreamObserver<HelloWorld.Request> requestObserver =
      asyncStub.chatHello(new StreamObserver<HelloWorld.Response>() {

        @Override public void onNext(HelloWorld.Response value) {
          logger.info(value.getData());

        }

        @Override public void onError(Throwable t) {
          finishFuture.setException(t);
        }

        @Override public void onCompleted() {
          finishFuture.set(null);
        }
      });

    try {
      for (int i = 0; i < 10; ++i) {
        HelloWorld.Request request = HelloWorld.Request.newBuilder().setName("" + i).build();
        requestObserver.onNext(request);
      }

      requestObserver.onCompleted();

      finishFuture.get();
    } catch (Exception t) {
      requestObserver.onError(t);
      logger.log(Level.WARNING, "RouteChat Failed", t);
    }

  }

  /**
   * client main 方法
   * 获取连接
   * 依次调用远端方法
   */
  public static void main(String[] args) throws Exception {
    HelloWorldClient client = new HelloWorldClient("localhost", 50051);
    try {
      String user = "vichen";
      if (args.length > 0) {
        user = args[0];
      }
      client.sayHello(user);
      client.sayHelloStreamResponse(user);
      client.sayHelloStreamRequest();
      client.chatHello();
    } finally {
      client.shutdown();
    }
  }


}
