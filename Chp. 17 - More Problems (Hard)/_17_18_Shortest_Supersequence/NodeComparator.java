package _17_18_Shortest_Supersequence;

import java.util.Comparator;

public class NodeComparator implements Comparator<HeapNode> {
    @Override
    public int compare(HeapNode n1, HeapNode n2) {
        return n1.index - n2.index;
    }
}