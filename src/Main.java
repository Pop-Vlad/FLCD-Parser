import Utils.ArbitraryTree;
import Utils.Grammar;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Grammar grammar = Grammar.fromFile("g2.txt");
        System.out.println(grammar.getNonterminals());
        System.out.println(grammar.getTerminals());
        System.out.println(grammar.getProductions());
        System.out.println("");
        System.out.println(grammar.getForProduction("condition"));
//        System.out.println(grammar.getForProduction("S"));
//        ArbitraryTree tree = new ArbitraryTree();
//        tree.add("S", "");
//        tree.add("a", "S");
//        System.out.println(tree);
    }
}
