import Utils.Grammar;
import Utils.ParserOutput;
import recursiveDescendant.RecursiveDescendant;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

public class Main1 {

    public static void main(String[] args) {
        try {
            Grammar grammar = Grammar.fromFile("g1.txt");
            printGrammar(grammar);

            RecursiveDescendant algoritmh = new RecursiveDescendant(grammar);
            List<String> w = Arrays.asList("a", "a", "c", "b", "c");

            List<String> productionString = algoritmh.run(w);
            ParserOutput parserOutput = new ParserOutput(grammar);
            parserOutput.addProductionString(productionString);

            System.out.println(parserOutput);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("g1out.txt")));
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
        System.out.println(grammar.getForProduction("S"));
        System.out.println("");
    }
}
