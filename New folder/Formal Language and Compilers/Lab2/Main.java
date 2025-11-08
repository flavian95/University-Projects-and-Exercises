public class Main {
    public static void main(String[] args) {
        String filePath = "automaton.txt";
        Automaton automaton = new Automaton();

        try {
            automaton.loadAutomaton(filePath);

            System.out.println("Transitions:");
            for (Transition transition : automaton.getTransitions()) {
                System.out.println("State1: " + transition.getState1() +
                        ", Symbol: " + transition.getSymbol() +
                        ", State2: " + transition.getState2());
            }

            System.out.println("\nStates:");
            for (String state : automaton.getStates()) {
                System.out.println(state);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
