package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DivideAStringIntoGroupsOfSizeK_2138Test {

  private final DivideAStringIntoGroupsOfSizeK_2138 solution =
      new DivideAStringIntoGroupsOfSizeK_2138();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("abcdefghi", 3, 'x', new String[] {"abc", "def", "ghi"}),
          arguments("abcdefghij", 3, 'x', new String[] {"abc", "def", "ghi", "jxx"}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void divideString(String str, int k, char fill, String[] expectedResult) {
    String[] actualResult = solution.divideString(str, k, fill);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
