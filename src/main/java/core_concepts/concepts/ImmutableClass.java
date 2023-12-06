package core_concepts.concepts;

import java.util.HashMap;
import java.util.Map;

/**
 * Immutable class means that once an object is created, we cannot change its content. In Java,
 * all the wrapper classes (like Integer, Boolean, Byte, Short) and String class is immutable.
 * We can create our own immutable class as well.
 *
 * Following are the requirements:
 *
 * The class must be declared as final (So that child classes can’t be created)
 * Data members in the class must be declared as private (So that direct access is not allowed)
 * Data members in the class must be declared as final (So that we can’t change the value of it after object creation)
 * A parameterized constructor should initialize all the fields performing a deep copy
 * (So that data members can’t be modified with object reference)
 * Deep Copy of objects should be performed in the getter methods (To return a copy rather than returning the actual object reference)
 * No setters (To not have the option to change the value of the instance variable)
 */
public final class ImmutableClass {

    private final String name;
    private final int age;
    private final Map<String,String> metadata;

    public ImmutableClass(String name, int age, Map<String, String> metadata) {

        this.name = name;
        this.age = age;
        this.metadata = getNewMap(metadata);
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Map<String, String> getMetadata() {
        return this.getNewMap(this.metadata);
    }

    /**
     * This method allow to us to do a deep copy related to have an immutable class.
     *
     * In other words this allows us to pass a copy (another memory reference object) when the
     * other classes use it.
     *
     * @param metadata the real inner hashMap
     * @return a deep copy of the real map.
     */
    private Map<String, String> getNewMap(Map<String, String> metadata) {
        Map<String, String> tempMap = new HashMap<>();
        //metadata.entrySet().forEach( entry -> tempMap.put(entry.getKey(), entry.getValue()));
        metadata.forEach(tempMap::put);
        return tempMap;
    }

}
