# Java 8 Features Overview

Java 8, released in March 2014, introduced several significant enhancements to the Java programming language and its core libraries. This document provides an overview of the key features introduced in Java 8.

## Table of Contents
- [Lambda Expressions](#lambda-expressions)
- [Stream API](#stream-api)
- [Date and Time API](#date-and-time-api)
- [Default Methods in Interfaces](#default-methods-in-interfaces)
- [Optional Class](#optional-class)
- [Nashorn JavaScript Engine](#nashorn-javascript-engine)
- [Other Enhancements](#other-enhancements)

## Lambda Expressions
Lambda expressions introduce a new syntax and capability to Java, allowing for clearer and more concise representation of single method interfaces (functional interfaces).

### Example
```java
List<String> names = Arrays.asList("John", "Jane", "Adam", "Tom");
Collections.sort(names, (String a, String b) -> {
    return b.compareTo(a);
});
