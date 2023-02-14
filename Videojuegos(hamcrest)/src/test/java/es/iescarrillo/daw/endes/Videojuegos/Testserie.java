package es.iescarrillo.daw.endes.Videojuegos;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Testserie {

  @Test
  public void testLengthOfTheUniqueKey() {
    String key = "unique_key";
    assertThat(key, hasLength(10));
  }

  @Test
  public void testStringEquality() {
    String s1 = "hello";
    String s2 = "hello";
    assertThat(s1, is(equalTo(s2)));
  }

  @Test
  public void testListIsNotEmpty() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
    assertThat(numbers, is(not(empty())));
  }

  @Test
  public void testMapContainsKey() {
    Map<String, Integer> map = new HashMap<String, Integer>();
    map.put("A", 1);
    map.put("B", 2);
    assertThat(map, hasKey("A"));
  }

  @Test
  public void testMapContainsValue() {
    Map<String, Integer> map = new HashMap<String, Integer>();
    map.put("A", 1);
    map.put("B", 2);
    assertThat(map, hasValue(2));
  }

  @Test
  public void testValueIsBetweenRange() {
    int value = 5;
    assertThat(value, is(both(greaterThan(3)).and(lessThan(7))));
  }
}

