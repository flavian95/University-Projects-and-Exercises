import java.util.ArrayList;

class TransitionList {
    private ArrayList<Transition> list = new ArrayList<>();

    // Adds a single transition to the list
    void addTransition(Transition tr) {
        this.list.add(tr);
    }

    // Adds a list of transitions to the list
    void addTransitions(ArrayList<Transition> trList) {
        this.list.addAll(trList);
    }

    // Clears all transitions in the list
    void clearTransitions() {
        this.list.clear();
    }

    // Finds a transition based on state and symbols
    Transition findTransition(String state, String symbols) {
        for (Transition temp : list) {
            if (temp.getStart().equals(state) && temp.getSymbols().equals(symbols)) {
                return temp;
            }
        }
        return null;
    }

    // Returns the list of transitions
    ArrayList<Transition> getTransitions() {
        return list;
    }
}