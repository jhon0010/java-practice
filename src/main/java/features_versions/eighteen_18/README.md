# Java 18 Features Summary

1. JEP 400: UTF-8 by Default
   Changes the default charset of the Java SE Platform to UTF-8, standardizing character encoding and simplifying internationalization.
2. JEP 408: Simple Web Server
   Introduces a command-line tool to start a minimal HTTP server that serves static files, designed for testing, development, and debugging purposes.
3. JEP 413: Code Snippets in Java API Documentation
   Enhances JavaDoc to support code snippets, ensuring they are automatically validated to improve API documentation quality.
4. JEP 417: Vector API (Third Incubator)
   Continues to incubate the Vector API, enabling reliable runtime compilation to optimal vector instructions, improving performance for vectorizable computations.
5. JEP 418: Internet-Address Resolution SPI
   Introduces a service provider interface for host name and address resolution, allowing for customized resolution strategies and better integration with different network environments.
6. JEP 419: Foreign Function & Memory API (Second Incubator)
   Advances the Foreign Function & Memory API, part of Project Panama, to improve Java's interoperation with native code and memory.
   ## Focused Topics
7. 
   #### Dominance Checking and Same-Type Patterns
   While not directly mentioned as a feature or JEP in Java 18, the concept of dominance checking and same-type patterns may relate to enhancements in pattern matching (for instanceof and possibly in switch expressions) and record patterns in Java. Dominance checking ensures that pattern matching in switch expressions is exhaustive and unambiguous. However, specific enhancements regarding "DominanceCheckingSameType" as a feature might not be directly addressed in Java 18 but are part of ongoing improvements in pattern matching and type checking in the Java language.
   #### Exhaustiveness in Switch Expressions
   Java has been enhancing switch expressions to support pattern matching. Exhaustiveness checking in switch expressions ensures that all possible cases are handled or a default case is provided. This feature was introduced to make switch expressions and pattern matching more robust and safer, preventing runtime errors due to unhandled cases.
   #### Internet Address Resolution SPI (JEP 418)
   This service provider interface (SPI) allows Java applications to customize how host names and IP addresses are resolved. It enables the replacement of the built-in address resolution mechanism with custom implementations, which can be crucial for applications running in environments with specific networking requirements or policies.
