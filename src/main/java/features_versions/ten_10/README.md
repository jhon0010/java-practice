# Java 10

1. Local-Variable Type Inference
   One of the most notable features introduced in Java 10 is the local-variable type inference, which allows developers to use the var keyword when declaring local variables. This feature simplifies the declaration of local variables with long or complex generic types. The compiler infers the type of the variable from the context, making the code cleaner and more readable.

2. Application Class-Data Sharing (CDS)
   To improve startup time and reduce memory footprint, Java 10 extended the existing Class-Data Sharing ("CDS") feature to allow application classes to be placed in the shared archive. This means that the Java Virtual Machine (JVM) can load classes faster and share common class metadata across different Java processes.

3. Time-Based Release Versioning
   Java 10 adopted a new time-based versioning model, with new major releases planned for every six months. This change aimed to make the release process more predictable and to provide developers with faster access to new features.

4. Garbage-Collector Interface
   Java 10 introduced a clean garbage collector (GC) interface that improves the source code isolation of different garbage collectors. This change is part of the ongoing effort to modularize the JVM codebase and make it easier to add new garbage collectors in the future.

5. Parallel Full GC for G1
   The G1 garbage collector was enhanced to perform full GC operations in parallel, reducing GC pause times. This improvement helps make G1 a more predictable and low-latency garbage collector, especially for applications running on large heaps.

6. Heap Allocation on Alternative Memory Devices
   This feature allows the HotSpot VM to allocate the Java object heap on an alternative memory device specified by the user. This is particularly useful for systems with multiple memory devices, such as Non-Volatile Dual In-line Memory Module (NVDIMM).

7. Experimental Java-Based JIT Compiler
   Java 10 introduced an experimental Just-In-Time (JIT) compiler, Graal, as an alternative to the existing JIT compiler in the HotSpot VM. Graal promises to bring new optimizations and performance improvements to Java applications.

8. Root Certificates
   Java 10 provided a default set of root Certification Authority (CA) certificates in the JDK, making it easier for developers to build and deploy secure applications without having to manage a separate set of CA certificates.

9. Thread-Local Handshakes
   This new feature introduced a way to perform a callback on threads without performing a global VM safe-point, making it possible to stop individual threads and not just all threads or none. This enhances the performance of the JVM by reducing the impact on application threads when performing certain GC operations and stack traces.

10. Remove the Native-Header Generation Tool (javah)
    Java 10 removed the javah tool, which was used to generate header files when using native methods. This functionality is now provided by the javac tool itself, simplifying the development process for applications that use native code.
