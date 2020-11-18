package recursiveDescendant;

import Utils.Grammar;
import Utils.Pair;

import java.util.List;

public class RecursiveDescendant {

    public Configuration configuration;
    public Grammar grammar;

    //expand, advance, momentary insucces, back, another try, succes


    public RecursiveDescendant(Configuration configuration, Grammar grammar) {
        this.configuration = configuration;
        this.grammar = grammar;
    }

    public void run(){
        if(grammar.nonterminals.contains(configuration.inputStack.get(0))){
            expand();
        }
    }

    public void expand(){
//        Pair<String, Integer> p = grammar.getForProduction(configuration.inputStack.get(0));
//        List<String> result = grammar.productions.get(p).get(0);

    }

    public void  advance(){

    }

    public void momentaryInsuccess(){

    }

    public void back(){

    }

    public void anotherTry(){

    }

    public void success(){

    }
}
