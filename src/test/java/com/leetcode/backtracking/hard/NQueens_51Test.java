package com.leetcode.backtracking.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NQueens_51Test {

  private final NQueens_51 solution = new NQueens_51();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              4,
              List.of(
                  List.of(".Q..", "...Q", "Q...", "..Q."),
                  List.of("..Q.", "Q...", "...Q", ".Q.."))),
          arguments(1, List.of(List.of("Q"))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void solveNQueens(int n, List<List<String>> expectedResult) {
    List<List<String>> actualResult = solution.solveNQueens(n);

    assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
  }
}
