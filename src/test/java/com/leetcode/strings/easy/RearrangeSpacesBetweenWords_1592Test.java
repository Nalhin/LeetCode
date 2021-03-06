package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RearrangeSpacesBetweenWords_1592Test {
  private final RearrangeSpacesBetweenWords_1592 solution = new RearrangeSpacesBetweenWords_1592();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("  this   is  a sentence ", "this   is   a   sentence"),
          arguments(" practice   makes   perfect", "practice   makes   perfect "),
          arguments("hello   world", "hello   world"),
          arguments("a", "a"),
          arguments("  walks  udp package   into  bar a", "walks  udp  package  into  bar  a "));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void reorderSpaces(String str, String expectedResult) {
    String actualResult = solution.reorderSpaces(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
