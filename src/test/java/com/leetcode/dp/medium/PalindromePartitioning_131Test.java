package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PalindromePartitioning_131Test {

  private final PalindromePartitioning_131 solution = new PalindromePartitioning_131();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("aab", List.of(List.of("a", "a", "b"), List.of("aa", "b"))),
          arguments("a", List.of(List.of("a"))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void partition(String input, List<List<String>> expectedResult) {
    List<List<String>> actualResult = solution.partition(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
