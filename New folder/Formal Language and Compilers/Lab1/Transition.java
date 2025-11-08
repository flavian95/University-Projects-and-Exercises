
class Transition {
    private String start;
    private char symbol;
    private String end;

    Transition(String start, char symbol, String end) {
        this.start = start;
        this.symbol = symbol;
        this.end = end;
    }

    String getStart() {
        return start;
    }

    char getSymbol() {
        return symbol;
    }

    String getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "(" + start + ", " + symbol + ") -> {" + end + "}";
    }
}