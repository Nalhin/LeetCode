package com.leetcode.strings.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StringTransformsIntoAnotherString_1153Test {

  private final StringTransformsIntoAnotherString_1153 solution = new StringTransformsIntoAnotherString_1153();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("aabcc", "ccdee", true),
          arguments("leetcode", "codeleet", false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void canConvert(String str1, String str2, boolean expectedResult) {
    boolean actualResult = solution.canConvert(str1, str2);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}