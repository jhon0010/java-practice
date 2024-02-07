# Java 14 Features Summary

1. Pattern Matching for instanceof (JEP 305) [Preview]
   Simplifies the instance-of operator with pattern matching, reducing the need for boilerplate code. This feature allows you to combine the instance-of check and variable assignment in a single, more readable operation.
2. Records (JEP 359) [Preview]
   Introduces a new type declaration, record, for declaring classes that are transparent holders for shallowly immutable data. Records aim to simplify the modeling of data aggregates with less syntactic and semantic overhead compared to traditional classes.
3. Text Blocks (Standard)
   Promotes text blocks to a standard feature, providing a new way to represent multi-line string literals that avoids the need for most escape sequences, making it easier to work with HTML, JSON, and SQL queries directly in Java code.
4. Switch Expressions (Standard)
   After being a preview feature in Java 12 and 13, switch expressions are standardized in Java 14, enhancing the switch statement and expression with a new form that is more flexible and safe.
5. Helpful NullPointerExceptions (JEP 358)
   Improves the usability of NullPointerExceptions by describing precisely which variable was null, making it easier to diagnose and fix null pointer exceptions in Java applications.
6. Foreign-Memory Access API (JEP 370) [Incubator]
   Introduces an API to allow Java programs to safely and efficiently access foreign memory outside of the Java heap. It's intended to replace unsafe and inefficient APIs like sun.misc.Unsafe for such operations.
7. Packaging Tool (JEP 343)
   Introduces a new tool, jpackage, for packaging self-contained Java applications along with a Java Runtime Environment (JRE), simplifying the deployment and distribution of Java applications.
8. NUMA-Aware Memory Allocation for G1
   Enhances the G1 garbage collector to improve its performance on large machines with Non-Uniform Memory Access (NUMA) architectures.
9. JFR Event Streaming (JEP 349)
   Extends Java Flight Recorder (JFR) with an API for continuous consumption of JFR data, both in-process and out-of-process, enabling real-time monitoring and analysis.
10. Deprecate the Solaris and SPARC Ports (JEP 362)
    Marks the Solaris/SPARC ports and the related HotSpot features as deprecated, in preparation for their removal in a future release.
11. Remove the Concurrent Mark Sweep (CMS) Garbage Collector (JEP 363)
    Removes the CMS garbage collector, which was deprecated in a previous version, focusing on more modern and efficient garbage collection techniques available in the JVM.
12. ZGC on macOS (JEP 364) and Windows (JEP 365)
    Extends the availability of the Z Garbage Collector (ZGC) to macOS and Windows, in addition to Linux, providing low-latency garbage collection across multiple platforms.
