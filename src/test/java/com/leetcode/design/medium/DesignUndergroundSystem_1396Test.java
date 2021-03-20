package com.leetcode.design.medium;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;
import com.leetcode.design.medium.DesignUndergroundSystem_1396.UndergroundSystem;

class DesignUndergroundSystem_1396Test {

  @Test
  void acceptanceTest() {
    UndergroundSystem system = new UndergroundSystem();
    SoftAssertions softAssertions = new SoftAssertions();

    system.checkIn(10, "Leyton", 3);
    system.checkOut(10, "Paradise", 8);
    softAssertions.assertThat(system.getAverageTime("Leyton", "Paradise")).isEqualTo(5);

    system.checkIn(5, "Leyton", 10);
    system.checkOut(5, "Paradise", 16);
    softAssertions.assertThat(system.getAverageTime("Leyton", "Paradise")).isEqualTo(5.5);

    system.checkIn(2, "Leyton", 21);
    system.checkOut(2, "Paradise", 30);

    softAssertions
        .assertThat(system.getAverageTime("Leyton", "Paradise"))
        .isCloseTo(6.66667, Percentage.withPercentage(0.01));

    softAssertions.assertAll();
  }
}
