import Utils.ArbitraryTree;
import Utils.Grammar;
import recursiveDescendant.RecursiveDescendant;

import java.util.Arrays;
import java.util.List;

public class Main1 {

    public static void main(String[] args) throws Exception {
        Grammar grammar = Grammar.fromFile("g1.txt");
        System.out.println("Nonterminals:" + grammar.getNonterminals());
        System.out.println("Terminals:" + grammar.getTerminals());
        System.out.println("Productions:\n" + grammar.getProductions());
        System.out.println(grammar.getForProduction("S"));

        RecursiveDescendant algoritmh = new RecursiveDescendant(grammar);
        List<String> w = Arrays.asList("a", "a", "c", "b", "c");

        List<String> productionString = algoritmh.run(w);
        ArbitraryTree arbitraryTree = new ArbitraryTree(grammar);
        arbitraryTree.addProductionString(productionString);

        System.out.println(arbitraryTree);
    }
}
