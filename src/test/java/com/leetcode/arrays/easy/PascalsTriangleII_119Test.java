package com.leetcode.arrays.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PascalsTriangleII_119Test {

  private final PascalsTriangleII_119 solution = new PascalsTriangleII_119();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(3, List.of(1, 3, 3, 1)), arguments(0, List.of(1)), arguments(1, List.of(1, 1)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void getRow(int input, List<Integer> expectedResult) {
    List<Integer> actualResult = solution.getRow(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
