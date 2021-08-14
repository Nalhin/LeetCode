package com.leetcode.dp.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RemoveBoxes_546Test {

  private final RemoveBoxes_546 solution = new RemoveBoxes_546();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 3, 2, 2, 2, 3, 4, 3, 1}, 23),
          arguments(new int[] {1, 1, 1}, 9),
          arguments(new int[] {1}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void removeBoxes(int[] boxes, int expectedResult) {
    int actualResult = solution.removeBoxes(boxes);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
