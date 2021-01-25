package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CoinChange2_518Test {

  private final CoinChange2_518 solution = new CoinChange2_518();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(5, new int[] {1, 2, 5}, 4),
          arguments(3, new int[] {2}, 0),
          arguments(10, new int[] {2}, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void change(int amount, int[] coins, int expectedResult) {

    int actualResult = solution.change(amount, coins);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
