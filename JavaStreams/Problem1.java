import java.util.*;
import java.util.stream.*;

public class Problem1 {

    public static void main(String[] args) {
        // Sample departments with employee names 
        List<List<String>> departments = Arrays.asList(
            Arrays.asList(" Alice ", " Bob", "Charlie"),
            Arrays.asList("David ", "Eve", " Frank "),
            Arrays.asList("George", "Hannah", "Ian"),
            Arrays.asList(" Jack", "Katie", "Liam")
        );

        // 1. Combine all employees from all departments and trim whitespace
        List<String> allEmployees = departments.stream()
            .flatMap(Collection::stream)
            .map(String::trim)
            .collect(Collectors.toList());

        System.out.println("All Employees: " + allEmployees);

        // 2. Filter employees whose names start with a specific letter (e.g., 'A')
        char filterLetter = 'A';
        List<String> filteredByLetter = allEmployees.stream()
            .filter(name -> name.startsWith(String.valueOf(filterLetter)))
            .sorted()
            .collect(Collectors.toList());

        System.out.println("Filtered and Sorted (Start with " + filterLetter + "): " + filteredByLetter);

        // 3. Group sorted names by starting letter
        Map<Character, List<String>> groupedByInitial = allEmployees.stream()
            .collect(Collectors.groupingBy(name -> name.charAt(0)));

        System.out.println("Grouped by Initial:");
        groupedByInitial.forEach((k, v) -> System.out.println(k + ": " + v));

        // 4. Shuffle and divide into 5 sports teams
        Collections.shuffle(allEmployees);
        int teamSize = (int) Math.ceil(allEmployees.size() / 5.0);

        List<List<String>> sportsTeams = new ArrayList<>();
        for (int i = 0; i < allEmployees.size(); i += teamSize) {
            sportsTeams.add(allEmployees.subList(i, Math.min(i + teamSize, allEmployees.size())));
        }

        System.out.println("\nSports Teams:");
        for (int i = 0; i < sportsTeams.size(); i++) {
            System.out.println("Team " + (i + 1) + ": " + sportsTeams.get(i));
        }

        // 5. Merge 5 sports teams into 3 divisions
        List<List<String>> divisions = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            divisions.add(new ArrayList<>());
        }

        for (int i = 0; i < sportsTeams.size(); i++) {
            divisions.get(i % 3).addAll(sportsTeams.get(i));
        }

        System.out.println("\nDivisions:");
        for (int i = 0; i < divisions.size(); i++) {
            System.out.println("Division " + (i + 1) + ": " + divisions.get(i));
        }
    }
}
