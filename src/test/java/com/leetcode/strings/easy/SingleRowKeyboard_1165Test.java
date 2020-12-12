package com.leetcode.strings.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SingleRowKeyboard_1165Test {

  private final SingleRowKeyboard_1165 solution = new SingleRowKeyboard_1165();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("abcdefghijklmnopqrstuvwxyz", "cba", 4),
          arguments("pqrstuvwxyzabcdefghijklmno", "leetcode", 73));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void calculateTime(String keyboard, String word, int expectedResult) {
    int actualResult = solution.calculateTime(keyboard, word);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
