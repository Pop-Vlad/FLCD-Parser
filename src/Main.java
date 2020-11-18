import Utils.Grammar;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Grammar grammar = Grammar.fromFile("g1.txt");
        System.out.println("Nonterminals:" + grammar.getNonterminals());
        System.out.println("Terminals:" + grammar.getTerminals());
        System.out.println("Productions:\n" + grammar.getProductions());
        System.out.println("");
        System.out.println(grammar.getForProduction("S"));
//        Grammar grammar = Grammar.fromFile("g2.txt");
//        System.out.println(grammar.getNonterminals());
//        System.out.println(grammar.getTerminals());
//        System.out.println(grammar.getProductions());
//        System.out.println("");
//        System.out.println(grammar.getForProduction("condition"));
    }
}
