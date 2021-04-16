package com.leetcode.stack.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RemoveAllAdjacentDuplicatesInStringII_1209Test {

  private final RemoveAllAdjacentDuplicatesInStringII_1209 solution =
      new RemoveAllAdjacentDuplicatesInStringII_1209();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("abcd", 2, "abcd"),
          arguments("deeedbbcccbdaa", 3, "aa"),
          arguments("pbbcggttciiippooaais", 2, "ps"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void removeDuplicates(String str, int k, String expectedResult) {
    String actualResult = solution.removeDuplicates(str, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
