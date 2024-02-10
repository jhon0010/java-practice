package features_versions.nineteen_19.base;

import jdk.jfr.MemoryAddress;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * In Java 21, explicit allocators require additional permissions in your security manager due to potential security risks.
 * Ensure proper memory management when using explicit allocators to avoid leaks or corruption.
 * Consider using memory leak detection tools when working with off-heap memory.
 *
 * This is WIP example, just showing how to use the Foreign Function & Memory API.
 */
import static java.lang.foreign.ValueLayout.*;

public class ForeignFunctionMemoryAPI {

    public static void main(String[] args) throws Throwable {

        // 1. Find foreign function on the C library path
        Linker linker = Linker.nativeLinker();
        SymbolLookup stdlib = linker.defaultLookup();

        // 2. Allocate on-heap memory to store strings
        String[] javaStrings = {"d", "z", "b", "c", "a"};

        // Container for all bytes
        List<Byte> byteList = new ArrayList<>();

        // Convert each string to a byte array and add to the list
        for (String s : javaStrings) {
            byte[] tempArray = s.getBytes(StandardCharsets.UTF_8);
            for (byte b : tempArray) {
                byteList.add(b);
            }
        }

        // Convert the List<Byte> to byte[]
        byte[] byteArray = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            byteArray[i] = byteList.get(i);
        }


        // 3. Allocate off-heap memory to store pointers
        MemorySegment offHeap = MemorySegment.ofArray(byteArray);
        SegmentAllocator allocator = SegmentAllocator.prefixAllocator(offHeap);

        // 4. Copy the strings from on-heap to off-heap
        for (int i = 0; i < javaStrings.length; i++) {

            // Allocate a string off-heap, then store a pointer to it
            MemorySegment cString = allocator.allocateUtf8String(javaStrings[i]);
            offHeap.setAtIndex(ValueLayout.ADDRESS, i, cString);
        }

        MethodHandle radixSort = linker.downcallHandle(
                stdlib.find("radixsort").orElseThrow(),
                FunctionDescriptor.ofVoid(ADDRESS, JAVA_INT, ADDRESS, JAVA_CHAR));

        // 5. Sort the off-heap data by calling the foreign function
        radixSort.invoke(offHeap, javaStrings.length, null, '\0');

        // 6. Copy the (reordered) strings from off-heap to on-heap
        for (int i = 0; i < javaStrings.length; i++) {
            MemorySegment cStringPtr = offHeap.getAtIndex(ADDRESS, i);
            javaStrings[i] = cStringPtr.getUtf8String(0);
        }

        //print sort result
        for (String javaString : javaStrings) {
            System.out.println(javaString);
        }

    }

}
