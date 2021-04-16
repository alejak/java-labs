public class NumberedItem<T> {
  T t;
  int i;

  NumberedItem(int i, T t) {
    this.i = i;
    if (i < 0) this.i = 0;
    this.t = t;
  }

  public int compareTo(NumberedItem<T> item) {
    return this.i - item.getIndex();
  }

  public int getIndex() {
    return this.i;
  }

  public String toString() {
    return ("Index: " + i + "Value: " + t);
  }
}
