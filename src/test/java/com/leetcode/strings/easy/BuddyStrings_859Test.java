package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BuddyStrings_859Test {

  private final BuddyStrings_859 solution = new BuddyStrings_859();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("ab", "ba", true),
          arguments("ab", "ab", false),
          arguments("aa", "aa", true),
          arguments("ab", "aa", false),
          arguments("aaaaaaabc", "aaaaaaacb", true),
          arguments("", "aa", false),
          arguments("dd", "ba", false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void buddyStrings(String input1, String input2, boolean expectedResult) {

    boolean actualResult = solution.buddyStrings(input1, input2);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
