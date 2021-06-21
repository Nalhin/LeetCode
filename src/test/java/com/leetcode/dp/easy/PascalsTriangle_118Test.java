package com.leetcode.dp.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PascalsTriangle_118Test {

  private final PascalsTriangle_118 solution = new PascalsTriangle_118();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              5,
              List.of(
                  List.of(1),
                  List.of(1, 1),
                  List.of(1, 2, 1),
                  List.of(1, 3, 3, 1),
                  List.of(1, 4, 6, 4, 1))),
          arguments(1, List.of(List.of(1))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void generate(int numRows, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solution.generate(numRows);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
