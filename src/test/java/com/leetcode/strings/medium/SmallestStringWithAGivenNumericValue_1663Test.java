package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SmallestStringWithAGivenNumericValue_1663Test {

  private final SmallestStringWithAGivenNumericValue_1663 solution =
      new SmallestStringWithAGivenNumericValue_1663();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(3, 27, "aay"), arguments(5, 73, "aaszz"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void getSmallestString(int n, int k, String expectedResult) {
    String actualResult = solution.getSmallestString(n, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
