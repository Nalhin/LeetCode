package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumMovesToReachTargetScore_2139Test {

  private final MinimumMovesToReachTargetScore_2139 solution =
      new MinimumMovesToReachTargetScore_2139();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(5, 0, 4), arguments(19, 2, 7), arguments(10, 4, 4));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minMoves(int target, int maxDoubles, int expectedResult) {
    int actualResult = solution.minMoves(target, maxDoubles);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
