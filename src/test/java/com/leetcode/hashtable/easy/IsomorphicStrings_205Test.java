package com.leetcode.hashtable.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class IsomorphicStrings_205Test {

  private final IsomorphicStrings_205 solution = new IsomorphicStrings_205();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("egg", "add", true),
          arguments("foo", "bar", false),
          arguments("ab", "aa", false),
          arguments("paper", "title", true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isIsomorphic(String first, String second, boolean expectedResult) {

    boolean actualResult = solution.isIsomorphic(first, second);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
