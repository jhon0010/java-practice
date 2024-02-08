package features_versions.seventeen_17.bases;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

/**
 * JEP 356, titled "Enhanced Pseudo-Random Number Generators," introduces a significant enhancement to the
 * pseudo-random number generation (PRNG) capabilities in Java 17.
 * This enhancement is designed to offer a more flexible and efficient approach for generating pseudo-random numbers,
 * catering to both general-purpose use cases and specific requirements that may need different characteristics
 * from a PRNG, such as better statistical properties, non-repeatability, and the ability to "jump" ahead in
 * the generated sequence of numbers.
 */
public class EnhancedPseudoRandomNumberGenerators {

    public static void main(String[] args) {

        //L128X256MixRandom is a new algorithm that is part of the enhanced PRNG capabilities in Java 17.
        RandomGeneratorFactory<RandomGenerator> factory = RandomGeneratorFactory.of("L128X256MixRandom");
        RandomGenerator randomGenerator = factory.create();

        System.out.println(randomGenerator.nextInt());
    }
}
