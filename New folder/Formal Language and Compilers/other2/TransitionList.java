import java.util.ArrayList;

class TransitionList {
    private ArrayList<Transition> list = new ArrayList<>();

    void addTransition(Transition tr) {
        this.list.add(tr);
    }

    Transition findTransition(String state, char symbol) {
        for (Transition transition : list) {
            if (transition.getStart().equals(state) && transition.getSymbol() == symbol) {
                return transition;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
