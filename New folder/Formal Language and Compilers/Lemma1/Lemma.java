class Lemma {
    private TransitionList trList;

    // Constructor to load automaton from a file
    Lemma(String filename) throws Exception {
        trList = new TransitionList();
        loadFromFile(filename);
    }

    // Load transitions from a text file
    private void loadFromFile(String filename) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        // Regex pattern for validation
        String transitionPattern = "^[A-Z]  [a-zA-Z#]+$";

        // Process the lines for transitions
        while ((line = reader.readLine()) != null) {
            line = line.trim(); // Remove extra spaces
            if (line.matches(transitionPattern)) {
                String[] parts = line.split("  ", 2); // Split into state and symbols
                String start = parts[0];
                String symbols = parts[1];
                Transition tr = new Transition(start, symbols);
                trList.addTransition(tr);
            } else {
                throw new Exception("Invalid transition format: " + line);
            }
        }

        reader.close();
    }

    public TransitionList getTransitionList() {
        return trList;
    }
}