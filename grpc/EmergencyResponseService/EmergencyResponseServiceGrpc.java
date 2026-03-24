package grpc.EmergencyResponseService;

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
    comments = "Source: EmergencyResponse.proto")
public final class EmergencyResponseServiceGrpc {

  private EmergencyResponseServiceGrpc() {}

  public static final String SERVICE_NAME = "EmergencyResponseService.EmergencyResponseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.EmergencyResponseService.ActionRequest,
      grpc.EmergencyResponseService.ActionResponse> getActivateSprinklersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ActivateSprinklers",
      requestType = grpc.EmergencyResponseService.ActionRequest.class,
      responseType = grpc.EmergencyResponseService.ActionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.EmergencyResponseService.ActionRequest,
      grpc.EmergencyResponseService.ActionResponse> getActivateSprinklersMethod() {
    io.grpc.MethodDescriptor<grpc.EmergencyResponseService.ActionRequest, grpc.EmergencyResponseService.ActionResponse> getActivateSprinklersMethod;
    if ((getActivateSprinklersMethod = EmergencyResponseServiceGrpc.getActivateSprinklersMethod) == null) {
      synchronized (EmergencyResponseServiceGrpc.class) {
        if ((getActivateSprinklersMethod = EmergencyResponseServiceGrpc.getActivateSprinklersMethod) == null) {
          EmergencyResponseServiceGrpc.getActivateSprinklersMethod = getActivateSprinklersMethod = 
              io.grpc.MethodDescriptor.<grpc.EmergencyResponseService.ActionRequest, grpc.EmergencyResponseService.ActionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "EmergencyResponseService.EmergencyResponseService", "ActivateSprinklers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.EmergencyResponseService.ActionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.EmergencyResponseService.ActionResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EmergencyResponseServiceMethodDescriptorSupplier("ActivateSprinklers"))
                  .build();
          }
        }
     }
     return getActivateSprinklersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.EmergencyResponseService.DeviceHealthRequest,
      grpc.EmergencyResponseService.DeviceStatusResponse> getMonitorDeviceStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorDeviceStatus",
      requestType = grpc.EmergencyResponseService.DeviceHealthRequest.class,
      responseType = grpc.EmergencyResponseService.DeviceStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.EmergencyResponseService.DeviceHealthRequest,
      grpc.EmergencyResponseService.DeviceStatusResponse> getMonitorDeviceStatusMethod() {
    io.grpc.MethodDescriptor<grpc.EmergencyResponseService.DeviceHealthRequest, grpc.EmergencyResponseService.DeviceStatusResponse> getMonitorDeviceStatusMethod;
    if ((getMonitorDeviceStatusMethod = EmergencyResponseServiceGrpc.getMonitorDeviceStatusMethod) == null) {
      synchronized (EmergencyResponseServiceGrpc.class) {
        if ((getMonitorDeviceStatusMethod = EmergencyResponseServiceGrpc.getMonitorDeviceStatusMethod) == null) {
          EmergencyResponseServiceGrpc.getMonitorDeviceStatusMethod = getMonitorDeviceStatusMethod = 
              io.grpc.MethodDescriptor.<grpc.EmergencyResponseService.DeviceHealthRequest, grpc.EmergencyResponseService.DeviceStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "EmergencyResponseService.EmergencyResponseService", "MonitorDeviceStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.EmergencyResponseService.DeviceHealthRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.EmergencyResponseService.DeviceStatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EmergencyResponseServiceMethodDescriptorSupplier("MonitorDeviceStatus"))
                  .build();
          }
        }
     }
     return getMonitorDeviceStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EmergencyResponseServiceStub newStub(io.grpc.Channel channel) {
    return new EmergencyResponseServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EmergencyResponseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EmergencyResponseServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EmergencyResponseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EmergencyResponseServiceFutureStub(channel);
  }

  /**
   * 
   * <pre>
   * Service definition for emergency response actions and device monitoring.
   * UNARY: Activate on-site sprinklers
   * BI-DIRECTIONAL: Real-time status feedback from devices
   * </pre>
   * 
   */
  public static abstract class EmergencyResponseServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * UNARY: Activate on-site sprinklers
     * </pre>
     */
    public void activateSprinklers(grpc.EmergencyResponseService.ActionRequest request,
        io.grpc.stub.StreamObserver<grpc.EmergencyResponseService.ActionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getActivateSprinklersMethod(), responseObserver);
    }

    /**
     * <pre>
     * BI-DIRECTIONAL: Real-time status feedback from devices
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.EmergencyResponseService.DeviceHealthRequest> monitorDeviceStatus(
        io.grpc.stub.StreamObserver<grpc.EmergencyResponseService.DeviceStatusResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getMonitorDeviceStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getActivateSprinklersMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.EmergencyResponseService.ActionRequest,
                grpc.EmergencyResponseService.ActionResponse>(
                  this, METHODID_ACTIVATE_SPRINKLERS)))
          .addMethod(
            getMonitorDeviceStatusMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.EmergencyResponseService.DeviceHealthRequest,
                grpc.EmergencyResponseService.DeviceStatusResponse>(
                  this, METHODID_MONITOR_DEVICE_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class EmergencyResponseServiceStub extends io.grpc.stub.AbstractStub<EmergencyResponseServiceStub> {
    private EmergencyResponseServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmergencyResponseServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmergencyResponseServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmergencyResponseServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * UNARY: Activate on-site sprinklers
     * </pre>
     */
    public void activateSprinklers(grpc.EmergencyResponseService.ActionRequest request,
        io.grpc.stub.StreamObserver<grpc.EmergencyResponseService.ActionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getActivateSprinklersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * BI-DIRECTIONAL: Real-time status feedback from devices
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.EmergencyResponseService.DeviceHealthRequest> monitorDeviceStatus(
        io.grpc.stub.StreamObserver<grpc.EmergencyResponseService.DeviceStatusResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getMonitorDeviceStatusMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class EmergencyResponseServiceBlockingStub extends io.grpc.stub.AbstractStub<EmergencyResponseServiceBlockingStub> {
    private EmergencyResponseServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmergencyResponseServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmergencyResponseServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmergencyResponseServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * UNARY: Activate on-site sprinklers
     * </pre>
     */
    public grpc.EmergencyResponseService.ActionResponse activateSprinklers(grpc.EmergencyResponseService.ActionRequest request) {
      return blockingUnaryCall(
          getChannel(), getActivateSprinklersMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EmergencyResponseServiceFutureStub extends io.grpc.stub.AbstractStub<EmergencyResponseServiceFutureStub> {
    private EmergencyResponseServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmergencyResponseServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmergencyResponseServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmergencyResponseServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * UNARY: Activate on-site sprinklers
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.EmergencyResponseService.ActionResponse> activateSprinklers(
        grpc.EmergencyResponseService.ActionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getActivateSprinklersMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ACTIVATE_SPRINKLERS = 0;
  private static final int METHODID_MONITOR_DEVICE_STATUS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EmergencyResponseServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EmergencyResponseServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ACTIVATE_SPRINKLERS:
          serviceImpl.activateSprinklers((grpc.EmergencyResponseService.ActionRequest) request,
              (io.grpc.stub.StreamObserver<grpc.EmergencyResponseService.ActionResponse>) responseObserver);
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
        case METHODID_MONITOR_DEVICE_STATUS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.monitorDeviceStatus(
              (io.grpc.stub.StreamObserver<grpc.EmergencyResponseService.DeviceStatusResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class EmergencyResponseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EmergencyResponseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.EmergencyResponseService.EmergencyResponseServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EmergencyResponseService");
    }
  }

  private static final class EmergencyResponseServiceFileDescriptorSupplier
      extends EmergencyResponseServiceBaseDescriptorSupplier {
    EmergencyResponseServiceFileDescriptorSupplier() {}
  }

  private static final class EmergencyResponseServiceMethodDescriptorSupplier
      extends EmergencyResponseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EmergencyResponseServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (EmergencyResponseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EmergencyResponseServiceFileDescriptorSupplier())
              .addMethod(getActivateSprinklersMethod())
              .addMethod(getMonitorDeviceStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
