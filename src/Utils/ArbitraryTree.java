package Utils;

import java.util.ArrayList;
import java.util.List;

public class ArbitraryTree {

    List<String> values;
    List<Integer> father;
    List<Integer> leftChild;
    List<Integer> rightSibling;

    public ArbitraryTree() {
        values = new ArrayList<>();
        father = new ArrayList<>();
        leftChild = new ArrayList<>();
        rightSibling = new ArrayList<>();
    }

    public int add(String node, int parent){
        values.add(node);
        int index = values.size() - 1;
        rightSibling.add(-1);
        leftChild.add(-1);
        if(parent == -1){
            return index;
        }

        if(leftChild.get(parent) == -1){
            leftChild.set(parent, index);
        }
        else {
            int current = leftChild.get(parent);
            System.out.println(current);
            int prev = -1;
            while (current != -1){
                prev = current;
                current = rightSibling.get(current);
            }
            rightSibling.set(prev, index);
        }
        father.add(parent);
        return index;
    }

    @Override
    public String toString() {
        return subtree(0);
    }

    private String subtree(int node){
        StringBuilder sb = new StringBuilder();
        int child = leftChild.get(node);
        sb.append(values.get(node));
        if(child == -1){
            return sb.toString();
        }
        while (child != -1){
            sb.append(subtree(child));
            child = rightSibling.get(child);
        }
        return sb.toString();
    }
}
