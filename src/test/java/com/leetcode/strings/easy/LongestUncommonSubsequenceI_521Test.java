package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestUncommonSubsequenceI_521Test {

  private final LongestUncommonSubsequenceI_521 solution = new LongestUncommonSubsequenceI_521();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("aba", "cdc", 3), arguments("aaa", "bbb", 3), arguments("aaa", "aaa", -1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findLUSlength(String str1, String str2, int expectedResult) {

    int actualResult = solution.findLUSlength(str1, str2);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
