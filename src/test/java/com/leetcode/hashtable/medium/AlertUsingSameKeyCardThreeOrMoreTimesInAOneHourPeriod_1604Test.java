package com.leetcode.hashtable.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod_1604Test {
  private final AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod_1604 solution =
      new AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod_1604();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new String[] {"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"},
              new String[] {"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"},
              List.of("daniel")),
          arguments(
              new String[] {"john", "john", "john"},
              new String[] {"23:58", "23:59", "00:01"},
              Collections.emptyList()),
          arguments(
              new String[] {"leslie", "leslie", "leslie", "clare", "clare", "clare", "clare"},
              new String[] {"13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49"},
              List.of("clare", "leslie")));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void alertNames(String[] keyName, String[] keyTime, List<String> expectedResult) {
    List<String> actualResult = solution.alertNames(keyName, keyTime);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
