package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ShiftingLetters_848Test {
  private final ShiftingLetters_848 solution = new ShiftingLetters_848();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("abc", new int[] {3, 5, 9}, "rpl"),
          arguments(
              "mkgfzkkuxownxvfvxasy",
              new int[] {
                505870226, 437526072, 266740649, 224336793, 532917782, 311122363, 567754492,
                595798950, 81520022, 684110326, 137742843, 275267355, 856903962, 148291585,
                919054234, 467541837, 622939912, 116899933, 983296461, 536563513
              },
              "wqqwlcjnkphhsyvrkdod"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void shiftingLetters(String str, int[] shifts, String expectedResult) {
    String actualResult = solution.shiftingLetters(str, shifts);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
