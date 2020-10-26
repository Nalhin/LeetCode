package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ChampagneTower_799Test {

  private final ChampagneTower_799 solution = new ChampagneTower_799();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(1, 1, 1, 0), arguments(2, 1, 1, 0.5), arguments(100000009, 33, 17, 1.0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void champagneTower(int poured, int row, int glass, double expectedResult) {

    double actualResult = solution.champagneTower(poured, row, glass);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
