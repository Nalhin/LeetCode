package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumDeletionsToMakeStringBalanced_1653Test {

  private final MinimumDeletionsToMakeStringBalanced_1653 solution =
      new MinimumDeletionsToMakeStringBalanced_1653();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("aababbab", 2), arguments("bbaaaaabb", 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minimumDeletions(String str, int expectedResult) {
    int actualResult = solution.minimumDeletions(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
