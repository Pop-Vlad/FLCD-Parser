import Utils.ArbitraryTree;
import Utils.Grammar;
import recursiveDescendant.RecursiveDescendant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) throws Exception {
        Grammar grammar = Grammar.fromFile("g2.txt");
        System.out.println("Nonterminals:" + grammar.getNonterminals());
        System.out.println("Terminals:" + grammar.getTerminals());
        System.out.println("Productions:\n" + grammar.getProductions());
        System.out.println(grammar.getForProduction("program"));

        RecursiveDescendant algoritmh = new RecursiveDescendant(grammar);

        Scanner scanner = new Scanner(new BufferedReader(new FileReader(new File("g2w.txt"))));
        List<String> w = new ArrayList<>();
        while (scanner.hasNext()) {
            w.add(scanner.nextLine());
        }

        List<String> productionString = algoritmh.run(w);
        ArbitraryTree arbitraryTree = new ArbitraryTree(grammar);
        arbitraryTree.addProductionString(productionString);

        System.out.println(arbitraryTree);
    }
}
