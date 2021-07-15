package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidTriangleNumber_611Test {
  private final ValidTriangleNumber_611 solution = new ValidTriangleNumber_611();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(new int[] {2, 2, 3, 4}, 3), arguments(new int[] {4, 2, 3, 4}, 4));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void triangleNumber(int[] nums, int expectedResult) {
    int actualResult = solution.triangleNumber(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
