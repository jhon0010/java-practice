# Java 14 Features Overview

Java 14, released in March 2020, brought several new features and enhancements to the Java programming language. This document outlines the key features introduced in this version.

## Table of Contents
- [Pattern Matching for instanceof](#pattern-matching-for-instanceof)
- [Records (Preview)](#records-preview)
- [Switch Expressions (Standard)](#switch-expressions-standard)
- [Text Blocks (Second Preview)](#text-blocks-second-preview)
- [Other Enhancements](#other-enhancements)

## Pattern Matching for instanceof
This feature enhances the `instanceof` operator to simplify its usage in programs, making the code more readable and concise.

### Example
```java
if (obj instanceof String s) {
    // use s directly here
}
```
