package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StoneGameVII_1690Test {

  private final StoneGameVII_1690.MinMax solutionMinMax = new StoneGameVII_1690.MinMax();
  private final StoneGameVII_1690.Dp solutionDp = new StoneGameVII_1690.Dp();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {5, 3, 1, 4, 2}, 6),
          arguments(new int[] {7, 90, 5, 1, 100, 10, 10, 2}, 122),
          arguments(new int[] {481, 905, 202, 250, 371, 628, 92, 604, 836, 338, 676, 734}, 3459));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void stoneGameVIIMinMax(int[] stones, int expectedResult) {
    int actualResult = solutionMinMax.stoneGameVII(stones);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void stoneGameVIIDp(int[] stones, int expectedResult) {
    int actualResult = solutionDp.stoneGameVII(stones);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
