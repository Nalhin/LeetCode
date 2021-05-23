package com.leetcode.design.medium;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class DesignTicTacToe_348Test {

  @Test
  void acceptanceTest() {
    DesignTicTacToe_348.TicTacToe tickTacToe = new DesignTicTacToe_348.TicTacToe(3);
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(tickTacToe.move(0, 0, 1)).isEqualTo(0);
    softAssertions.assertThat(tickTacToe.move(0, 2, 2)).isEqualTo(0);
    softAssertions.assertThat(tickTacToe.move(2, 2, 1)).isEqualTo(0);
    softAssertions.assertThat(tickTacToe.move(1, 1, 2)).isEqualTo(0);
    softAssertions.assertThat(tickTacToe.move(2, 0, 1)).isEqualTo(0);
    softAssertions.assertThat(tickTacToe.move(1, 0, 2)).isEqualTo(0);
    softAssertions.assertThat(tickTacToe.move(2, 1, 1)).isEqualTo(1);

    softAssertions.assertAll();
  }
}
