package com.leetcode.graph.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class JumpGameIII_1306Test {

  private final JumpGameIII_1306 solution = new JumpGameIII_1306();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {4, 2, 3, 0, 3, 1, 2}, 5, true),
          arguments(new int[] {4, 2, 3, 0, 3, 1, 2}, 0, true),
          arguments(new int[] {3, 0, 2, 1, 2}, 2, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void canReach(int[] arr, int start, boolean expectedResult) {
    boolean actualResult = solution.canReach(arr, start);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
