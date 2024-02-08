# Java 15 Features Summary

1. Sealed Classes (Preview)
   Introduces the concept of sealed classes and interfaces to restrict which other classes or interfaces may extend or implement them, enhancing control over inheritance.
2. Hidden Classes
   Supports the creation of classes that are not discoverable and are only used by the frameworks that generate them, improving encapsulation and reducing potential conflicts.
3. Text Blocks (Standard Feature)
   Promotes text blocks to a standard feature, facilitating the representation of multi-line string literals in a more readable and manageable way.
4. Records (Second Preview)
   Simplifies data modeling with a compact syntax for declaring classes as transparent holders of shallowly immutable data. This feature was in its second preview in Java 15.
5. Pattern Matching for instanceof (Second Preview)
   Enhances the instanceof operator with pattern matching capabilities to reduce boilerplate code when checking an object's type and casting it.
6. Edwards-Curve Digital Signature Algorithm (EdDSA)
   Introduces support for the EdDSA digital signature algorithm, offering a modern and efficient alternative for cryptographic signatures.
7. Garbage Collectors Enhancements and Removals
   Shenandoah GC: A low-pause-time garbage collector that became production-ready, focusing on reducing GC pause times.
   ZGC Enhancements: Improvements to the Z Garbage Collector to return unused memory to the operating system more efficiently.
   Removal of Nashorn JavaScript Engine: The Nashorn JavaScript engine, deprecated in Java 11, was removed.
   Disable and Deprecate Biased Locking: Aimed at simplifying the JVM by disabling and deprecating biased locking.
8. Reimplement the Legacy DatagramSocket API
   Replaces the underlying implementations of the java.net.DatagramSocket and java.net.MulticastSocket APIs to improve maintainability and performance.
9. Foreign-Memory Access API (Second Incubator)
   Provides an API for safely and efficiently accessing foreign memory outside of the Java heap, continuing its incubation for further feedback and refinement.
10. JFR Event Streaming
    Enhances Java Flight Recorder (JFR) with an API for streaming events, allowing for continuous monitoring and analysis of application performance and system events.
