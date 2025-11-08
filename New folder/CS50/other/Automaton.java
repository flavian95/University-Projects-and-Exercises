import java.util.ArrayList;

class Automaton {
    private String initialState;
    private TransitionList trList;
    private ArrayList<String> finalStates;

    Automaton(String initialState, TransitionList trList, ArrayList<String> finalStates) {
        this.initialState = initialState;
        this.trList = trList;
        this.finalStates = finalStates;
    }

    // Accept function to check if a string is accepted
    boolean accept(String input) {
        String currentState = initialState;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            Transition transition = trList.findTransition(currentState, symbol);
            if (transition == null) {
                return false;
            }
            currentState = transition.getEnd();
        }
        return finalStates.contains(currentState);
    }

    // Kleene Star operation
    Automaton kleeneStar() {
        Automaton kleeneAutomaton = new Automaton(initialState, trList, finalStates);
        kleeneAutomaton.finalStates.add(initialState);
        return kleeneAutomaton;
    }

    // Union operation
    static Automaton union(Automaton a1, Automaton a2) {
        TransitionList newTransitions = new TransitionList();
        newTransitions.addAll(a1.trList.getTransitions());
        newTransitions.addAll(a2.trList.getTransitions());

        ArrayList<String> combinedFinalStates = new ArrayList<>(a1.finalStates);
        combinedFinalStates.addAll(a2.finalStates);

        return new Automaton(a1.initialState, newTransitions, combinedFinalStates);
    }

    @Override
    public String toString() {
        return "Initial State: " + initialState + ", Transitions: " + trList + ", Final States: " + finalStates;
    }
}
