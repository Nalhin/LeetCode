package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindKLengthSubstringsWithNoRepeatedCharacters_1100Test {
  private final FindKLengthSubstringsWithNoRepeatedCharacters_1100 solution =
      new FindKLengthSubstringsWithNoRepeatedCharacters_1100();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("havefunonleetcode", 5, 6), arguments("home", 5, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numKLenSubstrNoRepeats(String str, int k, int expectedResult) {
    int actualResult = solution.numKLenSubstrNoRepeats(str, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
