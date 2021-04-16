import java.util.*;

public class SVector<E> implements SparseVector<E> {

  TreeMap<Integer,E> map;

  SVector () {
      this.map = new TreeMap();
      // this.set = new SortedSet();
  }

  public void add(E elem) {          // add at lowest positive index not it use
    for (int i=0;;i++) {
      if (null == map.get(i)) {
        add(i, elem);
        return;
      }
    }
  }

  public void add(int pos, E elem) { // if pos is occupied, replace with elem, if pos<0, use 0
    if (pos < 0) pos = 0;
    map.put(pos, elem);
  }

  // find first (lowest index) occurence of elem, return its index,
  // if not found, return -1
  public int indexOf(E elem) {
    for (Map.Entry<Integer,E> entry : map.entrySet()) {
      if (elem == entry.getValue()) return entry.getKey();
    }

    return -1;
  }

  public void removeAt(int pos) {    // if index pos is not used, nothing happens
    map.remove(pos);
  }

  public void removeElem(E elem) {   // remove first occurence (lowest index) of elem
    int pos = indexOf(elem);
    if (pos > -1) removeAt(pos);
  }

  public int size() {
    return map.size();
  }

  public int minIndex() {            // lowest index in use
    if (size() == 0) return -1;
    return map.firstKey();
  }

  public int maxIndex() {            // highest index in use
    if (size() == 0) return -1;
    return map.lastKey();
  }

  public String toString() {         // sorted by index
    StringBuilder svString = new StringBuilder();  // StringBuilder for efficiency
    svString.append("{\n");

    // Iterate over set of all mappings in map
    for (Map.Entry<Integer,E> entry : map.entrySet()) {
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
    return map.get(pos);
  }

  // test
  // public static void main(String[] args) {
  //   SVector<String> sv = new SVector();
  //   System.out.println("Size: " + sv.size());
  //   System.out.println("Empty minIndex: " + sv.minIndex());
  //   System.out.println("Empty maxIndex: " + sv.maxIndex());
  //   System.out.println("Get empty mapping: " + sv.get(0));
  //
  //   sv.add(0, "Zero");
  //   sv.add(1, "One");
  //   System.out.println("Size: " + sv.size());
  //
  //   sv.add(4, "Four");
  //   sv.add(10, "Ten");
  //   sv.add(6, "Eight");
  //   System.out.println("Size: " + sv.size());
  //
  //   sv.add(6, "Seven");
  //   sv.add(6, "Six");
  //   System.out.println("Size: " + sv.size());
  //
  //   sv.add("Two");
  //   sv.add("Three");
  //   System.out.println("Size: " + sv.size());
  //   System.out.println("Value at index 2: " + sv.get(2));
  //   System.out.println("Value at index 3: " + sv.get(3));
  //
  //   sv.removeAt(4);
  //   System.out.println("Size: " + sv.size());
  //   sv.add(4, "Six");
  //   System.out.println("Size: " + sv.size());
  //   sv.removeElem("Six");
  //   System.out.println("Size: " + sv.size());
  //   System.out.println("Index of value 'Six': " + sv.indexOf("Six"));
  //
  //   System.out.println(sv);
  // }
}
