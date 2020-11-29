package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CheckIfTwoStringArraysAreEquivalent_1662Test {

  private final CheckIfTwoStringArraysAreEquivalent_1662 solution =
      new CheckIfTwoStringArraysAreEquivalent_1662();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(new String[] {"ab", "c"}, new String[] {"a", "bc"}, true),
          arguments(new String[] {"a", "cb"}, new String[] {"ab", "c"}, false),
          arguments(new String[] {"abc", "d", "defg"}, new String[] {"abcddefg"}, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void arrayStringsAreEqual(String[] arr1, String[] arr2, boolean expectedResult) {

    boolean actualResult = solution.arrayStringsAreEqual(arr1, arr2);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
