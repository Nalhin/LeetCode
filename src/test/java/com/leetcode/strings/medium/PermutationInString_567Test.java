package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PermutationInString_567Test {

  private final PermutationInString_567 solution = new PermutationInString_567();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("ab", "eidbaooo", true), arguments("ab", "eidboaoo", false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void checkInclusion(String s1, String s2, boolean expectedResult) {
    boolean actualResult = solution.checkInclusion(s1, s2);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
