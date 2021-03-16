package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BuildingsWithAnOceanView_1762Test {
  private final BuildingsWithAnOceanView_1762 solution = new BuildingsWithAnOceanView_1762();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {4, 2, 3, 1}, new int[] {0, 2, 3}),
          arguments(new int[] {4, 3, 2, 1}, new int[] {0, 1, 2, 3}),
          arguments(new int[] {1, 3, 2, 4}, new int[] {3}),
          arguments(new int[] {2, 2, 2, 2}, new int[] {3}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findBuildings(int[] heights, int[] expectedResult) {
    int[] actualResult = solution.findBuildings(heights);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
