import java.io.*;
import java.util.*;

public class Automaton {
    private List<Transition> trlist = new ArrayList<>();
    private Set<String> states = new HashSet<>();

    public void loadAutomaton(String filePath) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        String state_regexp = "q([1-9][0-9]*|0)";
        String symbol_regexp = "[a-z]";

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");

            if (parts.length == 1) {
                String state = parts[0];

                if (!state.matches(state_regexp)) {
                    throw new Exception("Invalid state format (leading zeros are not allowed): " + state);
                }

                states.add(state);
            } else if (parts.length == 3) {

                if (parts[0].matches(state_regexp) && parts[1].matches(symbol_regexp) && parts[2].matches(state_regexp)) {
                    trlist.add(new Transition(parts[0], parts[1].charAt(0), parts[2]));
                } else {
                    throw new Exception("Invalid transition format: " + line);
                }
            } else {

                throw new Exception("Invalid line format: " + line);
            }
        }

        reader.close();
    }

    public List<Transition> getTransitions() {
        return trlist;
    }

    public Set<String> getStates() {
        return states;
    }
}
