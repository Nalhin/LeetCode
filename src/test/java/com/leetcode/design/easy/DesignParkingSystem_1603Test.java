package com.leetcode.design.easy;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DesignParkingSystem_1603Test {

  @Nested
  class ParkingSystem {

    @Test
    void acceptanceTest() {
      DesignParkingSystem_1603.ParkingSystem system =
          new DesignParkingSystem_1603.ParkingSystem(1, 1, 0);

      SoftAssertions softly = new SoftAssertions();
      softly.assertThat(system.addCar(1)).isTrue();
      softly.assertThat(system.addCar(2)).isTrue();
      softly.assertThat(system.addCar(3)).isFalse();
      softly.assertThat(system.addCar(1)).isFalse();

      softly.assertAll();
    }
  }
}
