import Utils.ArbitraryTree;
import Utils.Grammar;
import recursiveDescendant.RecursiveDescendant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Grammar grammar = Grammar.fromFile("g2.txt");
        System.out.println("Nonterminals:" + grammar.getNonterminals());
        System.out.println("Terminals:" + grammar.getTerminals());
        System.out.println("Productions:\n" + grammar.getProductions());
        //System.out.println(grammar.getForProduction("S"));

        RecursiveDescendant algoritmh = new RecursiveDescendant(grammar);
        List<String> w = Arrays.asList("a", "a", "c", "b", "c");
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(new File("g2w.txt"))));
        w = new ArrayList<>();
        while (scanner.hasNext()) {
            w.add(scanner.nextLine());
        }

        List<String> productionString = algoritmh.run(w);
        ArbitraryTree arbitraryTree = new ArbitraryTree(grammar);
        arbitraryTree.addProductionString(productionString);

        System.out.println(arbitraryTree);
    }
}
