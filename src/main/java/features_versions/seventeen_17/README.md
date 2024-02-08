# Java 17 Features Summary

1. Sealed Classes (JEP 409)
   Sealed classes and interfaces restrict which other classes or interfaces may extend or implement them. After being in preview in earlier versions, sealed classes are now a standard feature, providing more precise control over inheritance.

2. Pattern Matching for instanceof (JEP 394)
   Simplifies conditional extraction of components from objects, reducing boilerplate code. This feature became standard in Java 16 and continues to be part of Java 17.
  
3. Strong Encapsulation of JDK Internals (JEP 403)
   Strongly encapsulates JDK internals by default, except for critical internal APIs such as sun.misc.Unsafe. This change aims to improve security and maintainability, encouraging the use of standard APIs.

4. Foreign Function & Memory API (JEP 412) [Incubator]
   Provides a pure Java API for calling native code and working with native memory, continuing the evolution of Project Panama. This feature is in the incubator stage in Java 17.
   
5. New macOS Rendering Pipeline (JEP 382)
   Introduces a new rendering pipeline for macOS, based on Apple's Metal framework, replacing the existing pipeline that used the deprecated OpenGL framework. This change enhances the performance and efficiency of Java applications on macOS.
6. Enhanced Pseudo-Random Number Generators (JEP 356)
   Introduces new interfaces and implementations for pseudo-random number generators (PRNGs), including jumpable PRNGs and an additional class of splittable PRNG algorithms (LXM).
  
7. Deprecate the Applet API for Removal (JEP 398)
   Marks the Applet API as deprecated for removal, acknowledging the obsolescence of applets and the shift towards modern web technologies.
8. Pattern Matching for Switch (JEP 406) [Preview]
   Extends pattern matching to the switch expression, allowing pattern matching within switch cases. This feature is in preview in Java 17.
  
9. Record Patterns, Array Patterns (JEP 405) [Preview]
   Introduces patterns for deconstructing records and arrays in pattern matching expressions. This feature is in preview and part of the ongoing effort to enhance the Java language's expressiveness and conciseness through pattern matching.
