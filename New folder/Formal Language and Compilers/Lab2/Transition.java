public class Transition {
    private String state1;
    private char symbol;
    private String state2;


    public Transition(String state1, char symbol, String state2) {
        this.state1 = state1;
        this.symbol = symbol;
        this.state2 = state2;
    }

    public String getState1() {
        return state1;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getState2() {
        return state2;
    }
}
