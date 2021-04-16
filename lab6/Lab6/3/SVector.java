import java.util.*;

public class SVector<E> extends TreeMap<Integer,E> implements SparseVector<E> {

  public void add(E elem) {          // add at lowest positive index not it use
    for (int i=0;;i++) {
      if (null == get(i)) {
        add(i, elem);
        return;
      }
    }
  }

  public void add(int pos, E elem) { // if pos is occupied, replace with elem, if pos<0, use 0
    if (pos < 0) pos = 0;
    put(pos, elem);
  }

  // find first (lowest index) occurence of elem, return its index,
  // if not found, return -1
  public int indexOf(E elem) {
    for (Map.Entry<Integer,E> entry : entrySet()) {
      if (elem == entry.getValue()) return entry.getKey();
    }

    return -1;
  }

  public void removeAt(int pos) {    // if index pos is not used, nothing happens
    remove(pos);
  }

  public void removeElem(E elem) {   // remove first occurence (lowest index) of elem
    int pos = indexOf(elem);
    if (pos > -1) removeAt(pos);
  }

  public int size() {
    return super.size();
  }

  public int minIndex() {            // lowest index in use
    if (size() == 0) return -1;
    return firstKey();
  }

  public int maxIndex() {            // highest index in use
    if (size() == 0) return -1;
    return lastKey();
  }

  public String toString() {         // sorted by index
    StringBuilder svString = new StringBuilder();  // StringBuilder for efficiency
    svString.append("{\n");

    // Iterate over set of all mappings in map
    for (Map.Entry<Integer,E> entry : entrySet()) {
      int key = entry.getKey();
      E value = entry.getValue();

      svString.append(key);
      svString.append(": ");
      svString.append(value);
      svString.append("\n");
    }

    svString.append("}");
    return svString.toString();
  }

  public E get(int pos) {            // return null if not available
    return super.get(pos);
  }
}
