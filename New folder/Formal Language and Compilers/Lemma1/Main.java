import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Transition tr1 = new Transition("q0", 'a', "q1");
        Transition tr2 = new Transition("q1", 'b', "q2");
        Transition tr3 = new Transition("q2", 'c', "q3");
        Transition tr4 = new Transition("q3", 'd', "q4");
        Transition tr5 = new Transition("q4", 'e', "q5");

        TransitionList trlist = new TransitionList();
        trlist.addTransition(tr1);
        trlist.addTransition(tr2);
        trlist.addTransition(tr3);
        trlist.addTransition(tr4);
        trlist.addTransition(tr5);

        Automaton automaton = new Automaton("q0", trlist, new ArrayList<String>());

        System.out.println(tr1);
    }
}