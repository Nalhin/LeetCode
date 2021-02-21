package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StringCompression_443Test {
  private final StringCompression_443 solution = new StringCompression_443();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new char[] {'a', 'a', 'b', 'b', 'c', 'c', 'c'},
              new char[] {'a', '2', 'b', '2', 'c', '3'}),
          arguments(new char[] {'a'}, new char[] {'a'}),
          arguments(
              new char[] {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'},
              new char[] {'a', 'b', '1', '2'}),
          arguments(
              new char[] {'a', 'a', 'a', 'b', 'b', 'a', 'a'},
              new char[] {'a', '3', 'b', '2', 'a', '2'}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void compress(char[] chars, char[] expectedResult) {
    int actualResult = solution.compress(chars);

    assertThat(Arrays.copyOfRange(chars, 0, actualResult)).isEqualTo(expectedResult);
  }
}
