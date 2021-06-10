package com.leetcode.design.medium;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class MyCalendarI_729Test {

  @Test
  void acceptanceTest() {
    MyCalendarI_729.MyCalendar calendar = new MyCalendarI_729.MyCalendar();
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(calendar.book(10, 20)).isTrue();
    softAssertions.assertThat(calendar.book(15, 25)).isFalse();
    softAssertions.assertThat(calendar.book(20, 30)).isTrue();
    softAssertions.assertAll();
  }
}
