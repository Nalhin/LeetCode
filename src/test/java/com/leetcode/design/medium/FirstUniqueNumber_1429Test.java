package com.leetcode.design.medium;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class FirstUniqueNumber_1429Test {

  @Test
  void acceptanceTest() {
    FirstUniqueNumber_1429.FirstUnique queue =
        new FirstUniqueNumber_1429.FirstUnique(new int[] {2, 3, 5});
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(queue.showFirstUnique()).isEqualTo(2);
    queue.add(5);
    softAssertions.assertThat(queue.showFirstUnique()).isEqualTo(2);
    queue.add(2);
    softAssertions.assertThat(queue.showFirstUnique()).isEqualTo(3);
    queue.add(3);
    softAssertions.assertThat(queue.showFirstUnique()).isEqualTo(-1);
    softAssertions.assertAll();
  }
}
