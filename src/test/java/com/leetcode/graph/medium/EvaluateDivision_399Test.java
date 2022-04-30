package com.leetcode.graph.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class EvaluateDivision_399Test {

  private final EvaluateDivision_399 solution = new EvaluateDivision_399();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              List.of(List.of("a", "b"), List.of("b", "c")),
              new double[] {2, 3},
              List.of(
                  List.of("a", "c"),
                  List.of("b", "a"),
                  List.of("a", "e"),
                  List.of("a", "a"),
                  List.of("x", "x")),
              new double[] {6.00000, 0.50000, -1.00000, 1.00000, -1.00000}),
          arguments(
              List.of(List.of("a", "b"), List.of("b", "c"), List.of("bc", "cd")),
              new double[] {1.5, 2.5, 5.0},
              List.of(List.of("a", "c"), List.of("c", "b"), List.of("bc", "cd"), List.of("cd", "bc")),
              new double[] {3.75000, 0.40000, 5.00000, 0.20000}),
          arguments(
              List.of(List.of("a", "b")),
              new double[] {0.5},
              List.of(List.of("a", "b"), List.of("b", "a"), List.of("a", "c"), List.of("x", "y")),
              new double[] {0.50000, 2.00000, -1.00000, -1.00000}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void calcEquation(
      List<List<String>> equations,
      double[] values,
      List<List<String>> queries,
      double[] expectedResult) {

    double[] actualResult = solution.calcEquation(equations, values, queries);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
