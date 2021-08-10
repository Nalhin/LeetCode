package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FlipStringToMonotoneIncreasing_926Test {

  private final FlipStringToMonotoneIncreasing_926 solution =
      new FlipStringToMonotoneIncreasing_926();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("001110", 1),
          arguments("010110", 2),
          arguments("00011000", 2),
          arguments("11011", 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minFlipsMonoIncr(String str, int expectedResult) {
    int actualResult = solution.minFlipsMonoIncr(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
