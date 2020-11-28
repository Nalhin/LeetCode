package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DecodeString_394Test {

  DecodeString_394 solution = new DecodeString_394();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("3[a]2[bc]", "aaabcbc"),
          arguments("3[a2[c]]", "accaccacc"),
          arguments("2[abc]3[cd]ef", "abcabccdcdcdef"),
          arguments("abc3[cd]xyz", "abccdcdcdxyz"),
          arguments(
              "10[leetcode]",
              "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void decodeString(String input, String expectedResult) {

    String actualResult = solution.decodeString(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
