package core_concepts.collections.maps;

import java.util.EnumMap;

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

/**
 * EnumMap is a specialized Map implementation for use with enum type keys.
 * All the keys in an enum map must come from a single enum type that is specified, explicitly or implicitly,
 * when the map is created.
 *
 * The key are enum type and that allow the EnumMap to be type safe, validating it at compile time.
 *
 * Fasts implementation = Enum maps are represented internally as arrays.
 * This representation is extremely compact and efficient.
 *
 */
public class EnumMapExample {

    public static void main(String[] args) {
        EnumMap<Day, String> activities = new EnumMap<>(Day.class);

        activities.put(Day.MONDAY, "Meeting");
        activities.put(Day.TUESDAY, "Coding");
        activities.put(Day.WEDNESDAY, "Gym");

        // Retrieve values based on enum keys
        String tuesdayActivity = activities.get(Day.TUESDAY);
        System.out.println("Tuesday's Activity: " + tuesdayActivity);
    }

}
