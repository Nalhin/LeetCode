package com.leetcode.hashtable.easy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.leetcode.hashtable.easy.DesignHashMap_706.MyHashMap;

class DesignHashMap_706Test {
  private static MyHashMap emptyHashMap() {
    return new MyHashMap();
  }

  private static MyHashMap hashMapOf(int key, int val, int... rest) {
    MyHashMap map = new MyHashMap();
    map.put(key, val);
    for (int i = 0; i < rest.length; i += 2) {
      map.put(rest[i], rest[i + 1]);
    }

    return map;
  }

  @Nested
  class Put {

    @Test
    void addsEntryWhenMapIsEmpty() {
      MyHashMap map = emptyHashMap();

      map.put(3, 4);

      assertThat(map.get(3)).isEqualTo(4);
    }

    @Test
    void overridesDuplicateKeys() {
      MyHashMap map = hashMapOf(3, 4);

      map.put(3, 5);

      assertThat(map.get(3)).isEqualTo(5);
    }
  }

  @Nested
  class Get {

    @Test
    void returnsValueIfKeyExistsInMap() {
      MyHashMap map = hashMapOf(4, 2, 1, 5);

      int actualResult = map.get(4);

      assertThat(actualResult).isEqualTo(2);
    }

    @Test
    void returnsFallbackValueIfKeyDoesntExist() {
      MyHashMap map = hashMapOf(4, 2, 1, 5);

      int actualResult = map.get(3);

      assertThat(actualResult).isEqualTo(-1);
    }
  }

  @Nested
  class Remove {
    @Test
    void removesEntryFromMap() {
      MyHashMap map = hashMapOf(3, 4);

      map.remove(3);

      assertThat(map.get(3)).isEqualTo(-1);
    }
  }
}
