package com.leetcode.arrays.easy;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class RemoveElement_27Test {

  private final RemoveElement_27 solution = new RemoveElement_27();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {3, 2, 2, 3}, 3, new int[] {2, 2}, 2),
          arguments(new int[] {0, 1, 2, 2, 3, 0, 4, 2}, 2, new int[] {0, 1, 3, 0, 4}, 5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void removeArguments(int[] input1, int input2, int[] transformedInput, int expected) {
    int result = solution.removeElement(input1, input2);

    SoftAssertions.assertSoftly(
        softly -> {
          softly.assertThat(result).isEqualTo(expected);
          softly.assertThat(input1).startsWith(transformedInput);
        });
  }
}
