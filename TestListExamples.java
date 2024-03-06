import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test 
	public void testFilter() {
    List<String> input1 = Arrays.asList("Moon", "Thomas", "Hello", "mOoN");
    StringChecker s = new IsMoon(){};
    List<String> result = ListExamples.filter(input1, s);
    List<String> expected = Arrays.asList("Moon", "mOoN");    
    assertEquals(expected, result);
	}
  
  @Test 
	public void testFilter2() {
    List<String> input1 = Arrays.asList("Tom", "Thomas", "T", "Hi");
    StringChecker s = new IsMoon(){};
    List<String> result = ListExamples.filter(input1, s);
    List<String> expected = Arrays.asList();    
    assertEquals(expected, result);
	}

  @Test 
	public void testFilter3() {
    List<String> input1 = Arrays.asList();
    StringChecker s = new IsMoon(){};
    List<String> result = ListExamples.filter(input1, s);
    List<String> expected = Arrays.asList();    
    assertEquals(expected, result);
	}
}
