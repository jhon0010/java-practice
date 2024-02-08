package features_versions.sixteen_16.basics;

import jdk.incubator.vector.IntVector;

/**
 * The Vector API is in its initial incubation phase for Java 16. The idea of this API is to provide a means of vector
 * computations that will ultimately be able to perform more optimally (on supporting CPU architectures)
 * than the traditional scalar method of computations.
 */
public class VectorApiIncubator {

    public static void main(String[] args) {
        traditionalVectorMultiplication();
        vectorMultiplication();
    }

    /**
     * This example of a scalar computation will, for an array of length 4, execute in 4 cycles. Now, let’s look at the
     * equivalent vector-based computation:
     */
    public static void traditionalVectorMultiplication() {
        int[] a = {1, 2, 3, 4};
        int[] b = {5, 6, 7, 8};

        var c = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] * b[i];
        }
    }

    /**
     * The first parameter is the size of the vector, followed by the array and the offset (here set to 0). The most
     * important thing here is the size of the vector that we’re getting to 128 bits.
     * In Java, each int takes 4 bytes to hold.
     *
     * On certain architectures, the compiler will be able to optimize the byte code to reduce the computation
     * from 4 to only 1 cycle.  These optimizations benefit areas such as machine learning and cryptography.
     */
    public static void vectorMultiplication() {

        int[] a = {1, 2, 3, 4};
        int[] b = {5, 6, 7, 8};
        int[] c = new int[a.length];

        var vectorA = IntVector.fromArray(IntVector.SPECIES_128, a, 0);
        var vectorB = IntVector.fromArray(IntVector.SPECIES_128, b, 0);
        var vectorC = vectorA.mul(vectorB);
        vectorC.intoArray(c, 0);
    }

}
