Project Overview
This system is a gRPC-based distributed application designed for wildfire prevention and climate action. 
It consists of 4 independent microservices coordinated by a Central Controller.
System ArchitectureThe system follows a microservices architecture using gRPC for efficient, real-time communication.
1. Temperature Monitoring Service (Port: 50051)
  - Role: Collects data from on-site thermal sensors.
  - Patterns:Unary: Get the latest temperature on demand.Server Streaming: Continuous real-time temperature updates.
2. Humidity Monitoring Service (Port: 50052)
  - Role: Monitors environmental moisture levels.
  - Patterns:Unary: One-time humidity check.Server Streaming: Continuous humidity data flow.
3. Risk Evaluation Service (Central Controller)
  - Role: The brain of the system. It aggregates data from temperature and humidity services.
  - Logic: Evaluates risk levels (LOW to CRITICAL) and triggers emergency protocols if thresholds are exceeded.
4. Fire Emergency Response Service (Port: 50053)
  - Role: Executes physical prevention measures.
  - Patterns:Unary: Activate sprinklers.Bi-directional: Real-time feedback from fire prevention devices.
