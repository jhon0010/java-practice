# Java 12 Features Summary

1. Switch Expressions (Preview)
   Enhances the switch statement to simplify its usage and improve code readability. Introduces a new arrow syntax (->) and allows switch to be used as either a statement or an expression.
2. Shenandoah: A Low-Pause-Time Garbage Collector
   A new garbage collection algorithm focused on reducing garbage collection pause times, especially for applications with large heaps and strict pause time requirements.
3. Microbenchmark Suite
   Includes a suite built on Java Microbenchmark Harness (JMH) to facilitate the creation of benchmarks for JDK itself and Java applications, aiding in performance measurement.
4. JEP 325: Switch Expressions (Preview)
   Officially introduces switch expressions as a preview feature, extending the switch statement for improved expressiveness and reducing boilerplate code.
5. JEP 334: JVM Constants API
   Provides an API for modeling nominal descriptions of key class-file and runtime artifacts, mainly for compiler and tools developers, offering programmatic access to constant pool structures.
6. JEP 340: One AArch64 Port, Not Two
   Consolidates the support for 64-bit ARM architectures by removing the redundant arm64 port, focusing on maintaining a single, more efficient aarch64 port.
7. JEP 341: Default CDS Archives
   Enhances Class Data Sharing (CDS) by enabling CDS archives by default, speeding up application startup times without additional configuration.
8. JEP 344: Abortable Mixed Collections for G1
   Improves the G1 garbage collector by making mixed collections abortable if they're too lengthy, potentially reducing pause times by splitting the collection work.
9. JEP 346: Promptly Return Unused Committed Memory from G1
   Optimizes the G1 garbage collector to automatically return unused Java heap memory to the operating system during idle times, lowering the memory footprint of idle applications.
