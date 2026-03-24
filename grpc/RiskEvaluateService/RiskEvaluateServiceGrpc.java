package grpc.RiskEvaluateService;

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
    comments = "Source: RiskEvaluation.proto")
public final class RiskEvaluateServiceGrpc {

  private RiskEvaluateServiceGrpc() {}

  public static final String SERVICE_NAME = "RiskEvaluateService.RiskEvaluateService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.RiskEvaluateService.EnvironmentalData,
      grpc.RiskEvaluateService.RiskAssessment> getEvaluateRiskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EvaluateRisk",
      requestType = grpc.RiskEvaluateService.EnvironmentalData.class,
      responseType = grpc.RiskEvaluateService.RiskAssessment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.RiskEvaluateService.EnvironmentalData,
      grpc.RiskEvaluateService.RiskAssessment> getEvaluateRiskMethod() {
    io.grpc.MethodDescriptor<grpc.RiskEvaluateService.EnvironmentalData, grpc.RiskEvaluateService.RiskAssessment> getEvaluateRiskMethod;
    if ((getEvaluateRiskMethod = RiskEvaluateServiceGrpc.getEvaluateRiskMethod) == null) {
      synchronized (RiskEvaluateServiceGrpc.class) {
        if ((getEvaluateRiskMethod = RiskEvaluateServiceGrpc.getEvaluateRiskMethod) == null) {
          RiskEvaluateServiceGrpc.getEvaluateRiskMethod = getEvaluateRiskMethod = 
              io.grpc.MethodDescriptor.<grpc.RiskEvaluateService.EnvironmentalData, grpc.RiskEvaluateService.RiskAssessment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RiskEvaluateService.RiskEvaluateService", "EvaluateRisk"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.RiskEvaluateService.EnvironmentalData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.RiskEvaluateService.RiskAssessment.getDefaultInstance()))
                  .setSchemaDescriptor(new RiskEvaluateServiceMethodDescriptorSupplier("EvaluateRisk"))
                  .build();
          }
        }
     }
     return getEvaluateRiskMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RiskEvaluateServiceStub newStub(io.grpc.Channel channel) {
    return new RiskEvaluateServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RiskEvaluateServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RiskEvaluateServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RiskEvaluateServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RiskEvaluateServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class RiskEvaluateServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * UNARY: Send snapshot and get risk assessment
     * </pre>
     */
    public void evaluateRisk(grpc.RiskEvaluateService.EnvironmentalData request,
        io.grpc.stub.StreamObserver<grpc.RiskEvaluateService.RiskAssessment> responseObserver) {
      asyncUnimplementedUnaryCall(getEvaluateRiskMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getEvaluateRiskMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.RiskEvaluateService.EnvironmentalData,
                grpc.RiskEvaluateService.RiskAssessment>(
                  this, METHODID_EVALUATE_RISK)))
          .build();
    }
  }

  /**
   */
  public static final class RiskEvaluateServiceStub extends io.grpc.stub.AbstractStub<RiskEvaluateServiceStub> {
    private RiskEvaluateServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RiskEvaluateServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RiskEvaluateServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RiskEvaluateServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * UNARY: Send snapshot and get risk assessment
     * </pre>
     */
    public void evaluateRisk(grpc.RiskEvaluateService.EnvironmentalData request,
        io.grpc.stub.StreamObserver<grpc.RiskEvaluateService.RiskAssessment> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEvaluateRiskMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RiskEvaluateServiceBlockingStub extends io.grpc.stub.AbstractStub<RiskEvaluateServiceBlockingStub> {
    private RiskEvaluateServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RiskEvaluateServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RiskEvaluateServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RiskEvaluateServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * UNARY: Send snapshot and get risk assessment
     * </pre>
     */
    public grpc.RiskEvaluateService.RiskAssessment evaluateRisk(grpc.RiskEvaluateService.EnvironmentalData request) {
      return blockingUnaryCall(
          getChannel(), getEvaluateRiskMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RiskEvaluateServiceFutureStub extends io.grpc.stub.AbstractStub<RiskEvaluateServiceFutureStub> {
    private RiskEvaluateServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RiskEvaluateServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RiskEvaluateServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RiskEvaluateServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * UNARY: Send snapshot and get risk assessment
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.RiskEvaluateService.RiskAssessment> evaluateRisk(
        grpc.RiskEvaluateService.EnvironmentalData request) {
      return futureUnaryCall(
          getChannel().newCall(getEvaluateRiskMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EVALUATE_RISK = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RiskEvaluateServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RiskEvaluateServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EVALUATE_RISK:
          serviceImpl.evaluateRisk((grpc.RiskEvaluateService.EnvironmentalData) request,
              (io.grpc.stub.StreamObserver<grpc.RiskEvaluateService.RiskAssessment>) responseObserver);
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

  private static abstract class RiskEvaluateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RiskEvaluateServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.RiskEvaluateService.RiskEvaluateServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RiskEvaluateService");
    }
  }

  private static final class RiskEvaluateServiceFileDescriptorSupplier
      extends RiskEvaluateServiceBaseDescriptorSupplier {
    RiskEvaluateServiceFileDescriptorSupplier() {}
  }

  private static final class RiskEvaluateServiceMethodDescriptorSupplier
      extends RiskEvaluateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RiskEvaluateServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RiskEvaluateServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RiskEvaluateServiceFileDescriptorSupplier())
              .addMethod(getEvaluateRiskMethod())
              .build();
        }
      }
    }
    return result;
  }
}
