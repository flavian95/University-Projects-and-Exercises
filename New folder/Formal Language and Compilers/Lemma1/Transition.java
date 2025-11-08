
class Transition {
    private String start;
    private String symbols;

    Transition(String start, String symbols) {
        this.start = start;
        this.symbols = symbols;
    }

    String getStart() {
        return start;
    }

    String getSymbols() {
        return symbols;
    }

    public String toString() {
        return start + " " + symbols;
    }
}