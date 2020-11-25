import Utils.Grammar;
import Utils.ParserOutput;
import recursiveDescendant.RecursiveDescendant;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        try {
            Grammar grammar = Grammar.fromFile("g2.txt");
            printGrammar(grammar);

            RecursiveDescendant algoritmh = new RecursiveDescendant(grammar);

            Scanner scanner = new Scanner(new BufferedReader(new FileReader(new File("g2w.txt"))));
            List<String> w = new ArrayList<>();
            while (scanner.hasNext()) {
                w.add(scanner.nextLine());
            }

            List<String> productionString = algoritmh.run(w);
            ParserOutput parserOutput = new ParserOutput(grammar);
            parserOutput.addProductionString(productionString);

            System.out.println(parserOutput);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("g2out.txt")));
            bufferedWriter.write(parserOutput.toString());
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printGrammar(Grammar grammar) {
        System.out.println("Nonterminals:" + grammar.getNonterminals());
        System.out.println("Terminals:" + grammar.getTerminals());
        System.out.println("Productions:\n" + grammar.getProductions());
        System.out.println("");
        System.out.println(grammar.getForProduction("expression"));
        System.out.println("");
    }
}
