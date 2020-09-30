package com.leetcode.hashtable.easy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumIII_170Test {

  @Nested
  class TwoSum {

    @Test
    void sumFound() {
      TwoSumIII_170.TwoSum twoSum = new TwoSumIII_170.TwoSum();
      twoSum.add(1);
      twoSum.add(2);
      twoSum.add(3);

      boolean actualResult = twoSum.find(4);

      assertThat(actualResult).isTrue();
    }

    @Test
    void sumNotFound() {
      TwoSumIII_170.TwoSum twoSum = new TwoSumIII_170.TwoSum();
      twoSum.add(1);
      twoSum.add(2);
      twoSum.add(3);

      boolean actualResult = twoSum.find(7);

      assertThat(actualResult).isFalse();
    }

    @Test
    void duplicateSearchedValueInsertedOnce() {
      TwoSumIII_170.TwoSum twoSum = new TwoSumIII_170.TwoSum();
      twoSum.add(0);

      boolean actualResult = twoSum.find(0);

      assertThat(actualResult).isFalse();
    }

    @Test
    void duplicateSearchedValueResultFoundLater() {
      TwoSumIII_170.TwoSum twoSum = new TwoSumIII_170.TwoSum();
      twoSum.add(0);
      twoSum.add(-1);
      twoSum.add(1);

      boolean actualResult = twoSum.find(0);

      assertThat(actualResult).isTrue();
    }
  }
}
