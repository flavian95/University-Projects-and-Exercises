import java.util.ArrayList;

public class Automaton {
    private String initial_state;
    private TransitionList trList;
    private ArrayList<String> final_state;

    Automaton(String initial_state, TransitionList trList, ArrayList<String> final_state) {
        this.initial_state = initial_state;
        this.trList = trList;
        this.final_state = final_state;
    }

    Automaton(String final_state) {
        this.final_state = new ArrayList<String>();
        this.final_state.add(final_state);
    }

    @Override
    public String toString() {
        return initial_state + " " + trList + " " + final_state;
    }

    public boolean accept(String userInput) {
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }
}