package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CountSortedVowelStrings_1641Test {

  private final CountSortedVowelStrings_1641.TopDownDp solutionTopDownDp =
      new CountSortedVowelStrings_1641.TopDownDp();

  private final CountSortedVowelStrings_1641.BottomUpDp solutionBottomUpDp =
      new CountSortedVowelStrings_1641.BottomUpDp();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(1, 5), arguments(2, 15), arguments(33, 66045));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countVowelStringsTopDownDp(int n, int expectedResult) {
    int actualResult = solutionTopDownDp.countVowelStrings(n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countVowelStringsBottomUp(int n, int expectedResult) {
    int actualResult = solutionBottomUpDp.countVowelStrings(n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
