package grpc.HumidityMonitoringService;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: HumidityMonitoring.proto")
public final class HumidityMonitoringServiceGrpc {

  private HumidityMonitoringServiceGrpc() {}

  public static final String SERVICE_NAME = "humidity.HumidityMonitoringService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.HumidityMonitoringService.LocationRequest,
      grpc.HumidityMonitoringService.HumidityResponse> getGetCurrentHumidityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCurrentHumidity",
      requestType = grpc.HumidityMonitoringService.LocationRequest.class,
      responseType = grpc.HumidityMonitoringService.HumidityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.HumidityMonitoringService.LocationRequest,
      grpc.HumidityMonitoringService.HumidityResponse> getGetCurrentHumidityMethod() {
    io.grpc.MethodDescriptor<grpc.HumidityMonitoringService.LocationRequest, grpc.HumidityMonitoringService.HumidityResponse> getGetCurrentHumidityMethod;
    if ((getGetCurrentHumidityMethod = HumidityMonitoringServiceGrpc.getGetCurrentHumidityMethod) == null) {
      synchronized (HumidityMonitoringServiceGrpc.class) {
        if ((getGetCurrentHumidityMethod = HumidityMonitoringServiceGrpc.getGetCurrentHumidityMethod) == null) {
          HumidityMonitoringServiceGrpc.getGetCurrentHumidityMethod = getGetCurrentHumidityMethod = 
              io.grpc.MethodDescriptor.<grpc.HumidityMonitoringService.LocationRequest, grpc.HumidityMonitoringService.HumidityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "humidity.HumidityMonitoringService", "GetCurrentHumidity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.HumidityMonitoringService.LocationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.HumidityMonitoringService.HumidityResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HumidityMonitoringServiceMethodDescriptorSupplier("GetCurrentHumidity"))
                  .build();
          }
        }
     }
     return getGetCurrentHumidityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.HumidityMonitoringService.LocationRequest,
      grpc.HumidityMonitoringService.HumidityResponse> getMonitorHumidityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorHumidity",
      requestType = grpc.HumidityMonitoringService.LocationRequest.class,
      responseType = grpc.HumidityMonitoringService.HumidityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.HumidityMonitoringService.LocationRequest,
      grpc.HumidityMonitoringService.HumidityResponse> getMonitorHumidityMethod() {
    io.grpc.MethodDescriptor<grpc.HumidityMonitoringService.LocationRequest, grpc.HumidityMonitoringService.HumidityResponse> getMonitorHumidityMethod;
    if ((getMonitorHumidityMethod = HumidityMonitoringServiceGrpc.getMonitorHumidityMethod) == null) {
      synchronized (HumidityMonitoringServiceGrpc.class) {
        if ((getMonitorHumidityMethod = HumidityMonitoringServiceGrpc.getMonitorHumidityMethod) == null) {
          HumidityMonitoringServiceGrpc.getMonitorHumidityMethod = getMonitorHumidityMethod = 
              io.grpc.MethodDescriptor.<grpc.HumidityMonitoringService.LocationRequest, grpc.HumidityMonitoringService.HumidityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "humidity.HumidityMonitoringService", "MonitorHumidity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.HumidityMonitoringService.LocationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.HumidityMonitoringService.HumidityResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HumidityMonitoringServiceMethodDescriptorSupplier("MonitorHumidity"))
                  .build();
          }
        }
     }
     return getMonitorHumidityMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HumidityMonitoringServiceStub newStub(io.grpc.Channel channel) {
    return new HumidityMonitoringServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HumidityMonitoringServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HumidityMonitoringServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HumidityMonitoringServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HumidityMonitoringServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class HumidityMonitoringServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * UNARY: Check current humidity
     * </pre>
     */
    public void getCurrentHumidity(grpc.HumidityMonitoringService.LocationRequest request,
        io.grpc.stub.StreamObserver<grpc.HumidityMonitoringService.HumidityResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCurrentHumidityMethod(), responseObserver);
    }

    /**
     * <pre>
     * SERVER STREAMING: Continuous humidity stream
     * </pre>
     */
    public void monitorHumidity(grpc.HumidityMonitoringService.LocationRequest request,
        io.grpc.stub.StreamObserver<grpc.HumidityMonitoringService.HumidityResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMonitorHumidityMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetCurrentHumidityMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.HumidityMonitoringService.LocationRequest,
                grpc.HumidityMonitoringService.HumidityResponse>(
                  this, METHODID_GET_CURRENT_HUMIDITY)))
          .addMethod(
            getMonitorHumidityMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.HumidityMonitoringService.LocationRequest,
                grpc.HumidityMonitoringService.HumidityResponse>(
                  this, METHODID_MONITOR_HUMIDITY)))
          .build();
    }
  }

  /**
   */
  public static final class HumidityMonitoringServiceStub extends io.grpc.stub.AbstractStub<HumidityMonitoringServiceStub> {
    private HumidityMonitoringServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HumidityMonitoringServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HumidityMonitoringServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HumidityMonitoringServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * UNARY: Check current humidity
     * </pre>
     */
    public void getCurrentHumidity(grpc.HumidityMonitoringService.LocationRequest request,
        io.grpc.stub.StreamObserver<grpc.HumidityMonitoringService.HumidityResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCurrentHumidityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * SERVER STREAMING: Continuous humidity stream
     * </pre>
     */
    public void monitorHumidity(grpc.HumidityMonitoringService.LocationRequest request,
        io.grpc.stub.StreamObserver<grpc.HumidityMonitoringService.HumidityResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getMonitorHumidityMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HumidityMonitoringServiceBlockingStub extends io.grpc.stub.AbstractStub<HumidityMonitoringServiceBlockingStub> {
    private HumidityMonitoringServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HumidityMonitoringServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HumidityMonitoringServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HumidityMonitoringServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * UNARY: Check current humidity
     * </pre>
     */
    public grpc.HumidityMonitoringService.HumidityResponse getCurrentHumidity(grpc.HumidityMonitoringService.LocationRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCurrentHumidityMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * SERVER STREAMING: Continuous humidity stream
     * </pre>
     */
    public java.util.Iterator<grpc.HumidityMonitoringService.HumidityResponse> monitorHumidity(
        grpc.HumidityMonitoringService.LocationRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getMonitorHumidityMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HumidityMonitoringServiceFutureStub extends io.grpc.stub.AbstractStub<HumidityMonitoringServiceFutureStub> {
    private HumidityMonitoringServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HumidityMonitoringServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HumidityMonitoringServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HumidityMonitoringServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * UNARY: Check current humidity
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.HumidityMonitoringService.HumidityResponse> getCurrentHumidity(
        grpc.HumidityMonitoringService.LocationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCurrentHumidityMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CURRENT_HUMIDITY = 0;
  private static final int METHODID_MONITOR_HUMIDITY = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HumidityMonitoringServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HumidityMonitoringServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CURRENT_HUMIDITY:
          serviceImpl.getCurrentHumidity((grpc.HumidityMonitoringService.LocationRequest) request,
              (io.grpc.stub.StreamObserver<grpc.HumidityMonitoringService.HumidityResponse>) responseObserver);
          break;
        case METHODID_MONITOR_HUMIDITY:
          serviceImpl.monitorHumidity((grpc.HumidityMonitoringService.LocationRequest) request,
              (io.grpc.stub.StreamObserver<grpc.HumidityMonitoringService.HumidityResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HumidityMonitoringServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HumidityMonitoringServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.HumidityMonitoringService.HumidityMonitoringServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HumidityMonitoringService");
    }
  }

  private static final class HumidityMonitoringServiceFileDescriptorSupplier
      extends HumidityMonitoringServiceBaseDescriptorSupplier {
    HumidityMonitoringServiceFileDescriptorSupplier() {}
  }

  private static final class HumidityMonitoringServiceMethodDescriptorSupplier
      extends HumidityMonitoringServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HumidityMonitoringServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HumidityMonitoringServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HumidityMonitoringServiceFileDescriptorSupplier())
              .addMethod(getGetCurrentHumidityMethod())
              .addMethod(getMonitorHumidityMethod())
              .build();
        }
      }
    }
    return result;
  }
}
