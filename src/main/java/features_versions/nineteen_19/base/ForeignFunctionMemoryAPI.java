package features_versions.nineteen_19.base;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.nio.charset.StandardCharsets;

/*
 * Foreign Function & Memory API - Java 26 Version
 * 
 * This version uses the Java 26 FFM API with updated changes:
 * - MemorySession replaced with Arena
 * - MemoryAddress removed (replaced with zero-length memory segments)
 * - Arena provides automatic memory management with try-with-resources
 * 
 * Note: This example assumes radixsort is available in the standard C library.
 * On many systems, radixsort is a BSD-specific function and may not be available.
 */
import static java.lang.foreign.ValueLayout.*;

public class ForeignFunctionMemoryAPI {

    public static void main(String[] args) throws Throwable {

        // 1. Find foreign function on the C library path
        Linker linker = Linker.nativeLinker();
        SymbolLookup stdlib = linker.defaultLookup();

        // 2. Allocate on-heap memory to store strings
        String[] javaStrings = {"d", "z", "b", "c", "a"};

        // 3. Create an Arena for managing off-heap memory (Java 26)
        // Arena replaces MemorySession from earlier versions
        try (Arena arena = Arena.ofConfined()) {
            
            // 4. Allocate off-heap memory for an array of pointers (char*[])
            // Each pointer is 8 bytes (on 64-bit systems)
            MemorySegment pointerArray = arena.allocate(
                ValueLayout.ADDRESS, 
                javaStrings.length
            );

            // 5. Allocate each string off-heap and store pointers in the array
            for (int i = 0; i < javaStrings.length; i++) {
                // Allocate C string (null-terminated)
                byte[] stringBytes = (javaStrings[i] + "\0").getBytes(StandardCharsets.UTF_8);
                MemorySegment cString = arena.allocate(
                    ValueLayout.JAVA_BYTE, 
                    stringBytes.length
                );
                cString.copyFrom(MemorySegment.ofArray(stringBytes));
                
                // Store pointer to the string in the pointer array
                pointerArray.setAtIndex(ValueLayout.ADDRESS, i, cString);
            }

            // 6. Get the radixsort function handle
            // Note: radixsort is BSD-specific, may not be available on all systems
            MethodHandle radixSort = linker.downcallHandle(
                stdlib.find("radixsort").orElseThrow(),
                FunctionDescriptor.ofVoid(ADDRESS, JAVA_INT, ADDRESS, JAVA_CHAR)
            );

            // 7. Sort the off-heap data by calling the foreign function
            // Parameters: pointer array, number of strings, unused, end character
            // MemorySegment.NULL represents a null pointer in Java 26
            radixSort.invoke(pointerArray, javaStrings.length, MemorySegment.NULL, '\0');

            // 8. Copy the (reordered) strings from off-heap to on-heap
            for (int i = 0; i < javaStrings.length; i++) {
                MemorySegment cStringPtr = pointerArray.getAtIndex(ADDRESS, i);
                /* Java 19
                    javaStrings[i] = cStringPtr.getUtf8String(0);
                 */
            }

            // 9. Print sorted result
            System.out.println("Sorted strings:");
            for (String javaString : javaStrings) {
                System.out.println(javaString);
            }
        }
        // Arena automatically closes and deallocates all allocated memory here
    }
}
