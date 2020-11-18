package recursiveDescendant;

import Utils.ArbitraryTree;
import Utils.Pair;

import java.util.List;

public class Configuration {

    public String state;
    public int position;
    public ArbitraryTree workingStack;
    public List<Pair<String, Integer>> inputStack;
}
