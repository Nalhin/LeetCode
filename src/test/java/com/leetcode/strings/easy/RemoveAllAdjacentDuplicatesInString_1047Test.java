package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RemoveAllAdjacentDuplicatesInString_1047Test {

  private final RemoveAllAdjacentDuplicatesInString_1047 solution =
      new RemoveAllAdjacentDuplicatesInString_1047();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("abbaca", "ca"), arguments("azxxzy", "ay"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void removeDuplicates(String str, String expectedResult) {
    String actualResult = solution.removeDuplicates(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
