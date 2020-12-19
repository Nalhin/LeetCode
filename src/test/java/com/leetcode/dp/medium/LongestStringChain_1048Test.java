package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestStringChain_1048Test {

  private final LongestStringChain_1048 solution = new LongestStringChain_1048();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new String[] {"a", "b", "ba", "bca", "bda", "bdca"}, 4),
          arguments(new String[] {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}, 5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestCommonSubsequence(String[] words, int expectedResult) {
    int actualResult = solution.longestStrChain(words);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
