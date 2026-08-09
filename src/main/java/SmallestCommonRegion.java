import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestCommonRegion {

    public static String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String,String> regionsMap = new HashMap<>();

        for (List<String> region : regions) {
            for (int i = 1; i < region.size(); i++) {
                String commonParent = region.getFirst();
                regionsMap.put(region.get(i), commonParent);
            }
        }

        String parent1 = regionsMap.get(region1);
        String parent2 = regionsMap.get(region2);

        while (!"Earth".equals(parent1)) {

            if (parent1.equals(parent2)) {
                return parent1;
            }
            if (regionsMap.get(parent1).equals(parent2) || regionsMap.get(parent2).equals(parent1)) {
                return regionsMap.get(parent1);
            }
            parent1 = regionsMap.get(parent1);
        }
        return parent1;
    }

    public static void main(String[] args) {
        List<List<String>> regions = Arrays.asList(
                Arrays.asList("Earth", "North America", "South America"),
                Arrays.asList("North America", "Mexico", "United States", "Canada"),
                Arrays.asList("South America", "Argentina", "Brazil", "Chile"),
                Arrays.asList("Mexico", "Oaxaca", "Puebla"),
                Arrays.asList("United States", "California", "Wyoming", "New York"),
                Arrays.asList("Canada", "Ontario", "Quebec", "Saskatchewan")
        );

        // Test cases
        System.out.println(findSmallestRegion(regions, "California", "Mexico")); // North America
        System.out.println(findSmallestRegion(regions, "Chile", "Puebla"));      // Earth
        System.out.println(findSmallestRegion(regions, "Ontario", "Quebec"));    // Canada
        System.out.println(findSmallestRegion(regions, "California", "New York")); // United States
        System.out.println(findSmallestRegion(regions, "Oaxaca", "Puebla"));       // Mexico
    }
}
