# Java 11 Features Overview

Java 11, as the first Long-Term Support (LTS) release after Java 8, brings several enhancements and new features to the Java platform:

## 1. Single-File Program Execution
- **Description**: Execute single-file Java programs without compiling them explicitly, simplifying the development and testing process for small programs.
- **Example Usage**: `java HelloWorld.java`

## 2. New String Methods
- **Description**: Introduces methods like `isBlank()`, `lines()`, `repeat(int)`, and `strip()` to enhance string manipulation capabilities.
- **Key Methods**:
   - `isBlank()`: Checks if the string is empty or contains only whitespace.
   - `lines()`: Returns a stream of lines from the string.
   - `repeat(int)`: Repeats the string the specified number of times.
   - `strip()`: Removes white space from both ends of the string.

## 3. Local-Variable Syntax for Lambda
- **Description**: Allows the use of the `var` keyword in lambda parameter definitions, enabling type inference for lambda parameters.
- **Example**: `(var s1, var s2) -> s1 + s2`

## 4. HTTP Client API (Standard)
- **Description**: Standardizes the HTTP Client API introduced in Java 9, supporting HTTP/2 and WebSocket, providing a modern way to handle HTTP requests.
- **Features**: Synchronous and asynchronous programming models, HTTP/2 support.

## 5. New File Methods
- **Description**: Simplifies file reading and writing operations with methods for directly dealing with strings.
- **Key Methods**:
   - `readString(Path)`: Reads all content from a file into a string.
   - `writeString(Path, CharSequence)`: Writes a string to a file.

## 6. Enhancements to Optional
- **Description**: Adds `Optional.isEmpty()` as a more readable alternative to `!isPresent()`.
- **Example**: `if (optional.isEmpty()) { ... }`

## 7. Removed Features and APIs
- **Description**: Removes deprecated APIs and features, including Java EE and CORBA modules, Nashorn JavaScript engine, and more, to streamline the platform.

## 8. Unicode 10
- **Description**: Updates Unicode support to Unicode 10, adding new characters, scripts, and symbols.

## 9. Flight Recorder
- **Description**: Open-sources Java Flight Recorder for profiling and diagnostics, previously a commercial feature in Oracle JDK.
- Java Flight Recorder (JFR) is a monitoring and profiling tool integrated into the Java Virtual Machine (JVM) that collects detailed runtime information about the JVM and applications running on it.
- Example command to start recording: `java -XX:StartFlightRecording=filename=myrecording.jfr,duration=60s MyApplication`

## 10. Security Enhancements
- **Description**: Includes support for TLS 1.3 and other security improvements to enhance application security.

Java 11 focuses on improving developer productivity, removing deprecated features, and enhancing the language and platform's security and performance.
