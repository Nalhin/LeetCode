package com.leetcode.design.medium;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LRUCache_146Test {

  @Nested
  class LRUCacheLinkedHashMap {

    @Test
    void acceptanceTest() {
      LRUCache_146.LRUCacheLinkedHashMap cache = new LRUCache_146.LRUCacheLinkedHashMap(2);
      SoftAssertions softAssertions = new SoftAssertions();

      cache.put(1, 1);
      cache.put(2, 2);
      softAssertions.assertThat(cache.get(1)).isEqualTo(1);
      cache.put(3, 3);
      softAssertions.assertThat(cache.get(2)).isEqualTo(-1);
      cache.put(4, 4);
      softAssertions.assertThat(cache.get(1)).isEqualTo(-1);
      softAssertions.assertThat(cache.get(3)).isEqualTo(3);
      softAssertions.assertThat(cache.get(4)).isEqualTo(4);
      softAssertions.assertAll();
    }
  }

  @Nested
  class LRUCacheCustomLL {

    @Test
    void acceptanceTest() {
      LRUCache_146.LRUCacheCustomLL cache = new LRUCache_146.LRUCacheCustomLL(2);
      SoftAssertions softAssertions = new SoftAssertions();
      cache.put(1, 1);
      cache.put(2, 2);
      softAssertions.assertThat(cache.get(1)).isEqualTo(1);
      cache.put(3, 3);
      softAssertions.assertThat(cache.get(2)).isEqualTo(-1);
      cache.put(4, 4);
      softAssertions.assertThat(cache.get(1)).isEqualTo(-1);
      softAssertions.assertThat(cache.get(3)).isEqualTo(3);
      softAssertions.assertThat(cache.get(4)).isEqualTo(4);
      softAssertions.assertAll();
    }
  }
}
