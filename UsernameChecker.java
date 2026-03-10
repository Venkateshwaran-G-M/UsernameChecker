 import java.util.*;
public class UsernameChecker {

    HashMap<String, Integer> userMap = new HashMap<>();
    HashMap<String, Integer> attemptFrequency = new HashMap<>();

    public boolean checkAvailability(String username) {

        attemptFrequency.put(username,
                attemptFrequency.getOrDefault(username, 0) + 1);

        return !userMap.containsKey(username);
    }

    public void registerUser(String username, int userId) {
        userMap.put(username, userId);
    }

    public List<String> suggestAlternatives(String username) {

        List<String> suggestions = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            suggestions.add(username + i);
        }

        suggestions.add(username.replace("_", "."));

        return suggestions;
    }

    public String getMostAttempted() {

        String result = "";
        int max = 0;

        for (String key : attemptFrequency.keySet()) {
            if (attemptFrequency.get(key) > max) {
                max = attemptFrequency.get(key);
                result = key;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        UsernameChecker system = new UsernameChecker();

        system.registerUser("john_doe", 101);

        System.out.println(system.checkAvailability("john_doe"));
        System.out.println(system.checkAvailability("jane_smith"));

        System.out.println(system.suggestAlternatives("john_doe"));
    }
}