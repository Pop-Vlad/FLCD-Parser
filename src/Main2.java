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
            System.out.println("Grammar:");
            printGrammar(grammar);

            RecursiveDescendant algorithm = new RecursiveDescendant(grammar);
            List<String> w = sequenceFromPIF("PIF.out");
            System.out.println("Sequence: " + w);

            List<String> productionString = algorithm.run(w);
            ParserOutput parserOutput = new ParserOutput(grammar);
            parserOutput.addProductionString(productionString);

            System.out.println(parserOutput);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out2.txt"));
            bufferedWriter.write(parserOutput.toString());
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<String> sequenceFromPIF(String pifFileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(pifFileName)));
        List<String> w = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            w.add(line.substring(line.indexOf('(') + 1, line.indexOf(',')));
        }
        return w;
    }

    public static void printGrammar(Grammar grammar) {
        System.out.println("Nonterminals:" + grammar.getNonterminals());
        System.out.println("Terminals:" + grammar.getTerminals());
        System.out.println("Productions:\n" + grammar.getProductions());
        System.out.println("Production for expression:");
        System.out.println(grammar.getForProduction("expression"));
        System.out.println();
    }
}
