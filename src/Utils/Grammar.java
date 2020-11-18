package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Grammar {

    public List<String> nonterminals;
    public List<String> terminals;
    public Map<String, List<List<String>>> productions;
    public String start;

    public Grammar() {
        nonterminals = new ArrayList<>();
        terminals = new ArrayList<>();
        productions = new HashMap<>();
        start = "";
    }

    public static Grammar fromFile(String fileName) throws FileNotFoundException {
        Grammar grammar = new Grammar();
        Scanner sc = new Scanner(new BufferedReader(new FileReader(new File(fileName))));
        String nonterminalsLine = sc.nextLine();
        grammar.nonterminals = Arrays.asList(nonterminalsLine.split(" "));
        String terminalsLine = sc.nextLine();
        grammar.terminals = Arrays.asList(terminalsLine.split(" "));
        grammar.start = sc.nextLine();
        String line;
        for(String nonterminal : grammar.nonterminals){
            grammar.productions.put(nonterminal, new ArrayList<>());
            System.out.println(nonterminal);
        }
        while (sc.hasNext()){
            line = sc.nextLine();
            String[] parts = line.split("->");
            String[] elements = parts[1].split("#");
            grammar.productions.get(parts[0]).add(Arrays.asList(elements));
        }
        sc.close();
        return grammar;
    }

    public List<String> getNonterminals(){
        return this.nonterminals;
    }

    public List<String> getTerminals(){
        return this.terminals;
    }

    public String getProductions(){
        StringBuilder sb = new StringBuilder();
        productions.keySet().forEach(p -> sb.append(getForProduction(p)).append("\n"));
        return sb.toString();
    }

    public String getForProduction(String nonterminal){
        List<List<String>> productions = this.productions.get(nonterminal);
        StringBuilder sb = new StringBuilder();
        sb.append(nonterminal).append("->");
        List<String> aux = new ArrayList<>();
        productions.forEach(p -> aux.add(p.stream().reduce("", (s,t) -> s+t)));
        aux.forEach(p -> sb.append(p).append("|"));
        return sb.toString();
    }
}
