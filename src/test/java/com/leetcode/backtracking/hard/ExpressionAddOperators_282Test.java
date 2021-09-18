package com.leetcode.backtracking.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ExpressionAddOperators_282Test {

  private final ExpressionAddOperators_282 solution = new ExpressionAddOperators_282();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("123", 6, List.of("1*2*3", "1+2+3")),
          arguments("232", 8, List.of("2*3+2", "2+3*2")),
          arguments("105", 5, List.of("1*0+5", "10-5")),
          arguments("00", 0, List.of("0*0", "0+0", "0-0")),
          arguments("3462347490", 9191, Collections.emptyList()));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void addOperators(String num, int target, List<String> expectedResult) {
    List<String> actualResult = solution.addOperators(num, target);

    assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
  }
}
