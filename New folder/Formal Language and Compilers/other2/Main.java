import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        try {
            TransitionList trlist = new TransitionList();
            ArrayList<String> finalStates = new ArrayList<>();
            String initialState = parseAutomatonFromFile("automaton1.txt", trlist, finalStates);

            Automaton automaton = new Automaton(initialState, trlist, finalStates);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Enter a string to test (or type 'exit' to quit): ");
                String userInput = scanner.nextLine();

                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }

                boolean result = automaton.accept(userInput);
                System.out.println("Does the automaton accept the string \"" + userInput + "\"? " + result);
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("Error reading the automaton file: " + e.getMessage());
        }
    }

    private static String parseAutomatonFromFile(String fileName, TransitionList trlist, ArrayList<String> finalStates)
            throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        String initialState = null;

        Pattern pattern = Pattern.compile("q[0-9]+ -> [a-zA-Z] -> q[0-9]+");

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty() || line.startsWith("#")) {
                continue;
            }

            Matcher matcher = pattern.matcher(line);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("Invalid line format in automaton file: " + line);
            }

            String[] parts = line.split("->");
            String startState = parts[0].trim();
            char symbol = parts[1].trim().charAt(0);
            String endState = parts[2].trim();

            trlist.addTransition(new Transition(startState, symbol, endState));

            if (initialState == null) {
                initialState = startState;
            }

            if (!finalStates.contains(endState)) {
                finalStates.add(endState);
            }
        }

        reader.close();

        if (initialState == null) {
            throw new IllegalArgumentException("No initial state found in the automaton file.");
        }

        return initialState;
    }
}