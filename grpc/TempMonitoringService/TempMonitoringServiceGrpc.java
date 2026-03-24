package grpc.TempMonitoringService;

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
    comments = "Source: TemperatureMonitoring.proto")
public final class TempMonitoringServiceGrpc {

  private TempMonitoringServiceGrpc() {}

  public static final String SERVICE_NAME = "TempMonitoringService.TempMonitoringService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.TempMonitoringService.LocationRequest,
      grpc.TempMonitoringService.TemperatureResponse> getGetCurrentTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCurrentTemperature",
      requestType = grpc.TempMonitoringService.LocationRequest.class,
      responseType = grpc.TempMonitoringService.TemperatureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.TempMonitoringService.LocationRequest,
      grpc.TempMonitoringService.TemperatureResponse> getGetCurrentTemperatureMethod() {
    io.grpc.MethodDescriptor<grpc.TempMonitoringService.LocationRequest, grpc.TempMonitoringService.TemperatureResponse> getGetCurrentTemperatureMethod;
    if ((getGetCurrentTemperatureMethod = TempMonitoringServiceGrpc.getGetCurrentTemperatureMethod) == null) {
      synchronized (TempMonitoringServiceGrpc.class) {
        if ((getGetCurrentTemperatureMethod = TempMonitoringServiceGrpc.getGetCurrentTemperatureMethod) == null) {
          TempMonitoringServiceGrpc.getGetCurrentTemperatureMethod = getGetCurrentTemperatureMethod = 
              io.grpc.MethodDescriptor.<grpc.TempMonitoringService.LocationRequest, grpc.TempMonitoringService.TemperatureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TempMonitoringService.TempMonitoringService", "GetCurrentTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.TempMonitoringService.LocationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.TempMonitoringService.TemperatureResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TempMonitoringServiceMethodDescriptorSupplier("GetCurrentTemperature"))
                  .build();
          }
        }
     }
     return getGetCurrentTemperatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.TempMonitoringService.LocationRequest,
      grpc.TempMonitoringService.TemperatureResponse> getMonitorTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorTemperature",
      requestType = grpc.TempMonitoringService.LocationRequest.class,
      responseType = grpc.TempMonitoringService.TemperatureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.TempMonitoringService.LocationRequest,
      grpc.TempMonitoringService.TemperatureResponse> getMonitorTemperatureMethod() {
    io.grpc.MethodDescriptor<grpc.TempMonitoringService.LocationRequest, grpc.TempMonitoringService.TemperatureResponse> getMonitorTemperatureMethod;
    if ((getMonitorTemperatureMethod = TempMonitoringServiceGrpc.getMonitorTemperatureMethod) == null) {
      synchronized (TempMonitoringServiceGrpc.class) {
        if ((getMonitorTemperatureMethod = TempMonitoringServiceGrpc.getMonitorTemperatureMethod) == null) {
          TempMonitoringServiceGrpc.getMonitorTemperatureMethod = getMonitorTemperatureMethod = 
              io.grpc.MethodDescriptor.<grpc.TempMonitoringService.LocationRequest, grpc.TempMonitoringService.TemperatureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "TempMonitoringService.TempMonitoringService", "MonitorTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.TempMonitoringService.LocationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.TempMonitoringService.TemperatureResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TempMonitoringServiceMethodDescriptorSupplier("MonitorTemperature"))
                  .build();
          }
        }
     }
     return getMonitorTemperatureMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TempMonitoringServiceStub newStub(io.grpc.Channel channel) {
    return new TempMonitoringServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TempMonitoringServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TempMonitoringServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TempMonitoringServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TempMonitoringServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TempMonitoringServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * UNARY: Get latest temperature right now
     * </pre>
     */
    public void getCurrentTemperature(grpc.TempMonitoringService.LocationRequest request,
        io.grpc.stub.StreamObserver<grpc.TempMonitoringService.TemperatureResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCurrentTemperatureMethod(), responseObserver);
    }

    /**
     * <pre>
     * SERVER STREAMING: Continuous data updates to controller
     * </pre>
     */
    public void monitorTemperature(grpc.TempMonitoringService.LocationRequest request,
        io.grpc.stub.StreamObserver<grpc.TempMonitoringService.TemperatureResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMonitorTemperatureMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetCurrentTemperatureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.TempMonitoringService.LocationRequest,
                grpc.TempMonitoringService.TemperatureResponse>(
                  this, METHODID_GET_CURRENT_TEMPERATURE)))
          .addMethod(
            getMonitorTemperatureMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.TempMonitoringService.LocationRequest,
                grpc.TempMonitoringService.TemperatureResponse>(
                  this, METHODID_MONITOR_TEMPERATURE)))
          .build();
    }
  }

  /**
   */
  public static final class TempMonitoringServiceStub extends io.grpc.stub.AbstractStub<TempMonitoringServiceStub> {
    private TempMonitoringServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TempMonitoringServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TempMonitoringServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TempMonitoringServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * UNARY: Get latest temperature right now
     * </pre>
     */
    public void getCurrentTemperature(grpc.TempMonitoringService.LocationRequest request,
        io.grpc.stub.StreamObserver<grpc.TempMonitoringService.TemperatureResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCurrentTemperatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * SERVER STREAMING: Continuous data updates to controller
     * </pre>
     */
    public void monitorTemperature(grpc.TempMonitoringService.LocationRequest request,
        io.grpc.stub.StreamObserver<grpc.TempMonitoringService.TemperatureResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getMonitorTemperatureMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TempMonitoringServiceBlockingStub extends io.grpc.stub.AbstractStub<TempMonitoringServiceBlockingStub> {
    private TempMonitoringServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TempMonitoringServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TempMonitoringServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TempMonitoringServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * UNARY: Get latest temperature right now
     * </pre>
     */
    public grpc.TempMonitoringService.TemperatureResponse getCurrentTemperature(grpc.TempMonitoringService.LocationRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCurrentTemperatureMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * SERVER STREAMING: Continuous data updates to controller
     * </pre>
     */
    public java.util.Iterator<grpc.TempMonitoringService.TemperatureResponse> monitorTemperature(
        grpc.TempMonitoringService.LocationRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getMonitorTemperatureMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TempMonitoringServiceFutureStub extends io.grpc.stub.AbstractStub<TempMonitoringServiceFutureStub> {
    private TempMonitoringServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TempMonitoringServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TempMonitoringServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TempMonitoringServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * UNARY: Get latest temperature right now
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.TempMonitoringService.TemperatureResponse> getCurrentTemperature(
        grpc.TempMonitoringService.LocationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCurrentTemperatureMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CURRENT_TEMPERATURE = 0;
  private static final int METHODID_MONITOR_TEMPERATURE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TempMonitoringServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TempMonitoringServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CURRENT_TEMPERATURE:
          serviceImpl.getCurrentTemperature((grpc.TempMonitoringService.LocationRequest) request,
              (io.grpc.stub.StreamObserver<grpc.TempMonitoringService.TemperatureResponse>) responseObserver);
          break;
        case METHODID_MONITOR_TEMPERATURE:
          serviceImpl.monitorTemperature((grpc.TempMonitoringService.LocationRequest) request,
              (io.grpc.stub.StreamObserver<grpc.TempMonitoringService.TemperatureResponse>) responseObserver);
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

  private static abstract class TempMonitoringServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TempMonitoringServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.TempMonitoringService.TempMonitoringServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TempMonitoringService");
    }
  }

  private static final class TempMonitoringServiceFileDescriptorSupplier
      extends TempMonitoringServiceBaseDescriptorSupplier {
    TempMonitoringServiceFileDescriptorSupplier() {}
  }

  private static final class TempMonitoringServiceMethodDescriptorSupplier
      extends TempMonitoringServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TempMonitoringServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TempMonitoringServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TempMonitoringServiceFileDescriptorSupplier())
              .addMethod(getGetCurrentTemperatureMethod())
              .addMethod(getMonitorTemperatureMethod())
              .build();
        }
      }
    }
    return result;
  }
}
