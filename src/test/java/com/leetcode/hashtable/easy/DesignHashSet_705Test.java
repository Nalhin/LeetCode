package com.leetcode.hashtable.easy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import com.leetcode.hashtable.easy.DesignHashSet_705.MyHashSet;

class DesignHashSet_705Test {

  private static MyHashSet emptyHashSet() {
    return new MyHashSet();
  }

  private static MyHashSet hashSetOf(int val, int... values) {
    MyHashSet set = new MyHashSet();
    set.add(val);
    for (int value : values) {
      set.add(value);
    }
    return set;
  }

  @Nested
  class Add {

    @Test
    void addsKeyWhenSetIsEmpty() {
      MyHashSet set = emptyHashSet();

      set.add(3);

      assertThat(set.contains(3)).isTrue();
    }

    @Test
    void doesntAddDuplicateValues() {
      MyHashSet set = hashSetOf(3);

      set.add(3);
      set.remove(3);

      assertThat(set.contains(3)).isFalse();
    }
  }

  @Nested
  class Remove {
    @Test
    void removesKeyFromSet() {
      MyHashSet set = hashSetOf(3);

      set.remove(3);

      assertThat(set.contains(3)).isFalse();
    }
  }

  @Nested
  class Contains {

    @Test
    void returnsTrueIfSetContainsKey() {
      MyHashSet set = hashSetOf(4, 2, 1, 5, 3);

      boolean actualResult = set.contains(3);

      assertThat(actualResult).isTrue();
    }

    @Test
    void returnsFalseIfSetDoesntContainKey() {
      MyHashSet set = hashSetOf(4, 2, 1, 5);

      boolean actualResult = set.contains(3);

      assertThat(actualResult).isFalse();
    }
  }
}
