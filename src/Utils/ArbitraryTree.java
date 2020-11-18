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

    public void add(String node, String parent){
        values.add(node);
        int index = values.size() - 1;
        rightSibling.add(-1);
        leftChild.add(-1);
        if(parent.equals("")){
            return;
        }
        int f = values.indexOf(parent);

        if(leftChild.get(f) == -1){
            leftChild.set(f, index);
        }
        else {
            int current = leftChild.get(f);
            int prev = -1;
            while (current != -1){
                current = rightSibling.get(current);
                prev = current;
            }
            rightSibling.set(prev, index);
        }
        father.add(f);

    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<values.size();i++){
            sb.append(values.get(i)).append("\n");
            int current = leftChild.get(i);
            sb.append("\t");
            while (current != -1){
                sb.append(values.get(current)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
