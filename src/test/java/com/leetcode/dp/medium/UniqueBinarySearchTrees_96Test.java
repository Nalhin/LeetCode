package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class UniqueBinarySearchTrees_96Test {

  private final UniqueBinarySearchTrees_96 solution = new UniqueBinarySearchTrees_96();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(1, 1), arguments(3, 5), arguments(19, 1767263190));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numTrees(int n, int expectedResult) {
    int actualResult = solution.numTrees(n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
