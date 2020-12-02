import Utils.Grammar;
import Utils.ParserOutput;
import recursiveDescendant.RecursiveDescendant;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        try {
            Grammar grammar = Grammar.fromFile("g1.txt");
            System.out.println("Grammar:");
            printGrammar(grammar);

            RecursiveDescendant algorithm = new RecursiveDescendant(grammar);
            List<String> w = sequenceFromFile("seq.txt");
            System.out.println("Sequence: " + w + "\n");

            List<String> productionString = algorithm.run(w);
            ParserOutput parserOutput = new ParserOutput(grammar);
            parserOutput.addProductionString(productionString);

            System.out.println(parserOutput);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("out1.txt")));
            bufferedWriter.write(parserOutput.toString());
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<String> sequenceFromFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(new File(fileName))));
        return Arrays.asList(scanner.nextLine().split(" "));
    }

    public static void printGrammar(Grammar grammar) {
        System.out.println("Nonterminals:" + grammar.getNonterminals());
        System.out.println("Terminals:" + grammar.getTerminals());
        System.out.println("Productions:\n" + grammar.getProductions());
        System.out.println("Production for S:");
        System.out.println(grammar.getForProduction("S"));
        System.out.println();
    }
}
