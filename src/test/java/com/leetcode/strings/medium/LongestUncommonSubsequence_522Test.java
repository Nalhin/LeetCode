package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestUncommonSubsequence_522Test {

  private final LongestUncommonSubsequence_522 solution = new LongestUncommonSubsequence_522();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new String[] {"aba", "cdc", "eae"}, 3),
          arguments(new String[] {"aaa", "aaa", "aa"}, -1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findLUSlength(String[] strs, int expectedResult) {
    int actualResult = solution.findLUSlength(strs);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
