import static org.junit.Assert.*;

import org.junit.Test;

public class SVTest {

  @Test
  public void testCompare() {

    SVector<String> sv = new SVector();
    assertEquals(0, sv.size());
    assertEquals(-1, sv.minIndex());
    assertEquals(-1, sv.maxIndex());
    assertNull(sv.get(0));

    sv.add(0, "Zero");
    sv.add(1, "One");
    assertEquals(2, sv.size());

    sv.add(4, "Four");
    sv.add(10, "Ten");
    sv.add(6, "Eight");
    assertEquals(5, sv.size());

    sv.add(6, "Seven");
    sv.add(6, "Six");
    assertEquals(5, sv.size());

    sv.add("Two");
    sv.add("Three");
    assertEquals(7, sv.size());
    assertEquals("Two", sv.get(2));
    assertEquals("Three", sv.get(3));

    sv.removeAt(4);
    assertEquals(6, sv.size());

    sv.add(4, "Six");
    assertEquals(7, sv.size());

    sv.removeElem("Six");
    assertEquals(6, sv.size());
    assertEquals(6, sv.indexOf("Six"));

    System.out.println(sv);
  }
}
