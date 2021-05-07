package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DeleteOperationForTwoStrings_583Test {

  private final DeleteOperationForTwoStrings_583 solution = new DeleteOperationForTwoStrings_583();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("sea", "eat", 2), arguments("leetcode", "etco", 4));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minDistance(String str1, String str2, int expectedResult) {
    int actualResult = solution.minDistance(str1, str2);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
