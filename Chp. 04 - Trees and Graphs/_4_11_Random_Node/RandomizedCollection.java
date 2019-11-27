// github.com/RodneyShag

package _4_11_Random_Node;

import java.util.*;

public class RandomizedCollection<T> {
    Random rand = new Random();
    List<T> list = new ArrayList();
    Map<T, Set<Integer>> valToIndices = new HashMap();

    public void add(T item) {
        // update Map
        if (!valToIndices.containsKey(item)) {
            valToIndices.put(item, new HashSet());
        }
        valToIndices.get(item).add(list.size());

        // update List
        list.add(item);

        return;
    }

    public boolean remove(T item) {
        if (!valToIndices.containsKey(item) || valToIndices.get(item).isEmpty()) {
            return false;
        }

        int indexToRemove = valToIndices.get(item).iterator().next();
        T itemLast = list.get(list.size() - 1);

        // update List
        list.set(indexToRemove, itemLast);
        list.remove(list.size() - 1);

        // update Map: remove overwritten index from set
        valToIndices.get(item).remove(indexToRemove);

        // update Map: update the moved number's index
        valToIndices.get(itemLast).add(indexToRemove);                              
        valToIndices.get(itemLast).remove(list.size());

        return true;
    }

    public boolean contains(T item) {
        return valToIndices.containsKey(item) && !valToIndices.get(item).isEmpty();
    }

    public T getRandom() {
        if (list.isEmpty()) {
            throw new Error("Collection is empty");
        }
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}
