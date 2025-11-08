import java.util.ArrayList;

public class TransitionList {
    private ArrayList<Transition> list = new ArrayList<Transition>();

    void addTransition(Transition tr) {
        this.list.add(tr);
    }

    Transition findTransition(String state, char symbol) {
        for (int i = 0; i < list.size(); i++) {
            Transition tmp = list.get(i);
            if (tmp.getStart().equals(state) && tmp.getSymbol() == symbol) {
                return tmp;
            }
        }
        return null;
    }
}