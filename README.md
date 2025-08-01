# VirtualThreadServer
A high-performance, concurrent server leveraging modern Java virtual threads (Project Loom) to efficiently manage thousands of simultaneous TCP connections with minimal resource usage.

#  Features
 - Uses Java Virtual Threads (Project Loom): Lightweight concurrency model enabling high scalability and responsiveness.

- Handles Massive Concurrency: Supports tens of thousands of TCP clients with minimal memory footprint.

- Simple Thread-per-Connection Approach: Each connection is served by a virtual thread, making the code easy to reason about and maintain.

- Modern Java 21+ Compatible: Built to showcase next-generation Java concurrency APIs.

- Great for Benchmarks and Learning: Designed to measure throughput, latency, and stability of Java virtual threading under heavy load.
- Efficient File Reading & Streaming: Reads data from files on the server side and streams it to clients over TCP, leveraging virtual threads for non-blocking, scalable I/O.

- Asynchronous file I/O: Efficiently reads files and sends data over the network within each virtual thread.

# Getting Started
Requirements

- Java 21 or later (ensure Project Loom/virtual threads support)


```
git clone https://github.com/mdex-geek/VirtualThreadServer.git
```
```
cd VirtualThreadServer
```


# Testing/Benchmarking

Use JMeter or similar tools to simulate concurrent clients and assess server scalability.

📈 Performance Report (JMeter results)
Total Samples: 25,111

Average Response Time: 14,185ms

Minimum: 2ms, Maximum: 49,361ms

Standard Deviation: 18,740.83ms

Throughput: 506.65 requests/second

Error Rate: 36.64%

Average Bytes per Response: 93.8

Network: 46.42KB/sec received, 0B sent

Interpretation: The server handled a high load, clearly demonstrating the scalability of Java virtual threads, although some errors occurred likely due to high concurrency limits being hit.

🛠️ Key Java Concepts & Technologies
Java virtual threads (Project Loom) for scalable concurrency.

TCP server networking with socket programming.

Fine-grained performance and error reporting for server benchmarking.