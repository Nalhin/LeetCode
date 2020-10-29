package com.leetcode.dp.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ClimbingStairs_70Test {

  private final ClimbingStairs_70 solution = new ClimbingStairs_70();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(2, 2), arguments(3, 3), arguments(42, 433494437));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void climbStairs(int n, int expectedResult) {
    int actualResult = solution.climbStairs(n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
