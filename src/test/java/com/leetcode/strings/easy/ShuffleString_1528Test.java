package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ShuffleString_1528Test {

  private final ShuffleString_1528 solution = new ShuffleString_1528();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("codeleet", new int[] {4, 5, 6, 7, 0, 2, 1, 3}, "leetcode"),
          arguments("abc", new int[] {0, 1, 2}, "abc"),
          arguments("aiohn", new int[] {3, 1, 4, 2, 0}, "nihao"),
          arguments("aaiougrt", new int[] {4, 0, 2, 6, 7, 3, 1, 5}, "arigatou"),
          arguments("art", new int[] {1, 0, 2}, "rat"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void restoreString(String str, int[] indices, String expectedResult) {
    String actualResult = solution.restoreString(str, indices);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
