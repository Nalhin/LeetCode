package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MergeStringsAlternately_1768Test {
  private final MergeStringsAlternately_1768 solution = new MergeStringsAlternately_1768();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("abc", "pqr", "apbqcr"),
          arguments("ab", "pqrs", "apbqrs"),
          arguments("abcd", "pq", "apbqcd"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void mergeAlternately(String str1, String str2, String expectedResult) {
    String actualResult = solution.mergeAlternately(str1, str2);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
