package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AddingSpacesToAString_2109Test {
  private final AddingSpacesToAString_2109 solution = new AddingSpacesToAString_2109();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("LeetcodeHelpsMeLearn", new int[] {8, 13, 15}, "Leetcode Helps Me Learn"),
          arguments("icodeinpython", new int[] {1, 5, 7, 9}, "i code in py thon"),
          arguments("spacing", new int[] {0, 1, 2, 3, 4, 5, 6}, " s p a c i n g"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void addSpaces(String s, int[] spaces, String expectedResult) {
    String actualResult = solution.addSpaces(s, spaces);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
