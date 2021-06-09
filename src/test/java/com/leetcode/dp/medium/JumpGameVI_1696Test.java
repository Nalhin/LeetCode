package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class JumpGameVI_1696Test {

  private final JumpGameVI_1696 solution = new JumpGameVI_1696();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, -1, -2, 4, -7, 3}, 2, 7),
          arguments(new int[] {10, -5, -2, 4, 0, 3}, 3, 17),
          arguments(new int[] {1, -5, -20, 4, -1, 3, -6, -3}, 2, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxResult(int[] num, int k, int expectedResult) {
    int actualResult = solution.maxResult(num, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
