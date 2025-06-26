package assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SetTest {
  @Test
  void testContainsWhenEmpty() {
    Set<String> set = new Set<>();

    assertFalse(set.contains("hello"));
  }

  @Test
  void testContainsWhenNotEmpty() {
    Set<String> set = new Set<>();
    set.add("hello");

    assertTrue(set.contains("hello"));
    assertFalse(set.contains("world"));
  }

  @Test
  void testAddMultiple() {
    Set<String> set = new Set<>();
    set.add("hello");

    assertTrue(set.contains("hello"));
    assertFalse(set.contains("world"));
    assertFalse(set.contains("foo"));

    set.add("world");

    assertTrue(set.contains("hello"));
    assertTrue(set.contains("world"));
    assertFalse(set.contains("foo"));
  }

  @Test
  void testRemove() {
    Set<String> set = new Set<>();
    set.add("hello");
    set.add("world");

    assertTrue(set.contains("hello"));
    assertTrue(set.contains("world"));

    set.remove("hello");

    assertFalse(set.contains("hello"));
    assertTrue(set.contains("world"));
  }

  @Test
  void testRemoveNonExistingElement() {
    Set<String> set = new Set<>();
    set.add("hello");

    set.remove("world");

    assertTrue(set.contains("hello"));
  }

  @Test
  void testAddDuplicateElement() {
    Set<String> set = new Set<>();
    set.add("hello");
    set.add("hello");

    assertTrue(set.contains("hello"));
    assertEquals(1, set.size());
  }

  @Test
  void testRemoveFromEmptySet() {
    Set<String> set = new Set<>();

    assertDoesNotThrow(() -> set.remove("nonexistent"));
  }

  @Test
  void testWithDifferentTypes() {
    Set<Integer> intSet = new Set<>();
    intSet.add(42);
    intSet.add(100);

    assertTrue(intSet.contains(42));
    assertFalse(intSet.contains(43));
  }
}
