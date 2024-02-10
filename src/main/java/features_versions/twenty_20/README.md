# Java 20 Features Overview

Scoped Values (JEP 429)
Purpose: To address the limitations and issues associated with ThreadLocal variables, such as mutability, memory leaks, and excessive memory footprints, Java 20 introduces scoped values.
Benefits: Scoped values offer an immutable, inheritable, and thread-local-like mechanism for sharing data, particularly useful in multi-threaded environments. They are designed to be accessible within a bounded execution scope, automatically reverting to an unbound state after execution, thus avoiding the common pitfalls of ThreadLocal.
Record Patterns (JEP 432)
Improvements: Building on the preview feature from JDK 19, Java 20 refines record patterns with added support for type inference in generic record patterns and usability in enhanced for loops, while removing named record patterns support.
Aim: To enable more expressive and composable data queries using pattern matching, enhancing the language's data handling capabilities without altering existing syntax or semantics.
Pattern Matching for Switch (JEP 433)
Enhancements: Java 20 continues to refine pattern matching for switch expressions and statements, particularly focusing on the grammar and usability, including throwing a MatchException for unmatched enum class cases, grammar improvements for switch labels, and supporting type-inference for arguments in generic record patterns.
Context: These changes expand the applicability of switch statements and expressions, making them more powerful and flexible for various use cases.
Foreign Function and Memory API (JEP 434)
Overview: This API, being previewed again in Java 20, facilitates safe and efficient interaction with native code and memory outside the Java heap.
Refinements: Unification of MemorySegment and MemoryAddress abstractions, enhancement of the sealed MemoryLayout hierarchy for pattern matching, and a division of MemorySession into Arena and SegmentScope for better segment sharing across maintenance boundaries.
Virtual Threads (JEP 436)
Second Preview: Following feedback from its first preview, virtual threads in Java 20 aim to simplify the development and maintenance of high-throughput concurrent applications, making server applications easier to debug and scale.
Updates: Making certain methods in Thread and Future permanent, extending ExecutorService with AutoCloseable, and permanent degradations to ThreadGroup for grouping virtual threads.
Structured Concurrency (JEP 437)
Re-incubation: With minimal changes from its initial incubation, this API focuses on simplifying multi-threaded programming by treating multiple tasks as a single unit of work, enhancing error handling and thread cancellation.
Change: The updated StructuredTaskScope supports inheritance of scoped values by threads, facilitating shared immutable data across threads.
Vector API (JEP 438)
Fifth Incubator: Continues to incubate without significant API changes, focusing on bug fixes and performance enhancements, aligning with Project Valhalla for future adaptations.
Purpose: Provides a mechanism for expressing vector computations that compile at runtime to optimal vector instructions on supported CPU architectures, aiming for performance improvements in computational tasks.
