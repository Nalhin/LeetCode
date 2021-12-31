package com.leetcode.design.medium;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;


class DesignALeaderboard_1244Test {

  @Test
  void acceptanceTest() {
    DesignALeaderboard_1244.Leaderboard leaderboard = new DesignALeaderboard_1244.Leaderboard();
    SoftAssertions softAssertions = new SoftAssertions();

    leaderboard.addScore(1,73);
    leaderboard.addScore(2,56);
    leaderboard.addScore(3, 39);
    leaderboard.addScore(4,51);
    leaderboard.addScore(5,4);
    softAssertions.assertThat(leaderboard.top(1)).isEqualTo(73);
    leaderboard.reset(1);
    leaderboard.reset(2);
    leaderboard.addScore(2,51);
    softAssertions.assertThat(leaderboard.top(3)).isEqualTo(141);
    softAssertions.assertAll();
  }
}