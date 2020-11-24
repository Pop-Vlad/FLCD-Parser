import Utils.ArbitraryTree;
import Utils.Grammar;
import recursiveDescendant.RecursiveDescendant;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Grammar grammar = Grammar.fromFile("g1.txt");
        System.out.println("Nonterminals:" + grammar.getNonterminals());
        System.out.println("Terminals:" + grammar.getTerminals());
        System.out.println("Productions:\n" + grammar.getProductions());
        System.out.println("");
        System.out.println(grammar.getForProduction("S"));

        RecursiveDescendant algoritmh = new RecursiveDescendant(grammar);
        List<String> w = Arrays.asList("a", "a", "c", "b", "c");
        List<String> productionString = algoritmh.run(w);
        ArbitraryTree arbitraryTree = new ArbitraryTree();
        int idx = -1;
        for(String p : productionString){
            idx = arbitraryTree.add("epsilon", idx);
        }
        System.out.println(arbitraryTree);

//        Grammar grammar = Grammar.fromFile("g2.txt");
//        System.out.println(grammar.getNonterminals());
//        System.out.println(grammar.getTerminals());
//        System.out.println(grammar.getProductions());
//        System.out.println("");
//        System.out.println(grammar.getForProduction("condition"));
    }
}
