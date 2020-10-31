package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class UniquePaths_62Test {

  private final UniquePaths_62.OneDimension solutionOneDimension =
      new UniquePaths_62.OneDimension();
  private final UniquePaths_62.TwoDimensions solutionTwoDimensions =
      new UniquePaths_62.TwoDimensions();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(3, 7, 28),
          arguments(3, 2, 3),
          arguments(7, 3, 28),
          arguments(3, 3, 6),
          arguments(1, 1, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void uniquePathsOneDimension(int m, int n, int expectedResult) {
    int actualResult = solutionOneDimension.uniquePaths(m, n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void uniquePathsTwoDimensions(int m, int n, int expectedResult) {
    int actualResult = solutionTwoDimensions.uniquePaths(m, n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
