package com.leetcode.design.medium;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class DesignAnATMMatchine_2241Test {

  @Test
  void acceptanceTest() {
    DesignAnATMMatchine_2241.ATM atm = new DesignAnATMMatchine_2241.ATM();
    SoftAssertions softAssertions = new SoftAssertions();

    atm.deposit(new int[] {0, 0, 1, 2, 1});
    softAssertions.assertThat(atm.withdraw(600)).isEqualTo(new int[] {0, 0, 1, 0, 1});
    atm.deposit(new int[] {0, 1, 0, 1, 1});
    softAssertions.assertThat(atm.withdraw(600)).isEqualTo(new int[] {-1});
    softAssertions.assertThat(atm.withdraw(550)).isEqualTo(new int[] {0, 1, 0, 0, 1});
    softAssertions.assertAll();
  }
}
