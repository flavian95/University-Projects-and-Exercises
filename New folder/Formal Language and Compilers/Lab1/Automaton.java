
import java.util.ArrayList;

class Automaton {
    private String initial_state;
    private TransitionList trList;
    private ArrayList<String> final_states;

    Automaton(String initial_state, TransitionList trList, ArrayList<String> final_states) {
        this.initial_state = initial_state;
        this.trList = trList;
        this.final_states = final_states;
    }

    Automaton(String final_state) {
        this.final_states = new ArrayList<>();
        this.final_states.add(final_state);
    }

    boolean accept(String input) {
        String currentState = initial_state;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            Transition transition = trList.findTransition(currentState, symbol);
            if (transition == null) {
                return false;
            }
            currentState = transition.getEnd();
        }
        return final_states.contains(currentState);
    }

    @Override
    public String toString() {
        return "Initial State: " + initial_state + ", Transitions: " + trList + ", Final States: " + final_states;
    }
}
