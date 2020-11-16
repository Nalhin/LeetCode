package com.leetcode.math.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PoorPigs_458Test {

  private final PoorPigs_458 solution = new PoorPigs_458();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(1000, 15, 60, 5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void poorPigs(int buckets, int minutesToDie, int minutesToTest, int expectedResult) {
    int actualResult = solution.poorPigs(buckets, minutesToDie, minutesToTest);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
