package com.leetcode.binarysearch.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindPeakElement_162Test {

  private final FindPeakElement_162 solution = new FindPeakElement_162();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3, 1}, 2), arguments(new int[] {1, 2, 1, 3, 56, 4}, 4));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findPeakElement(int[] nums, int expectedResult) {
    int actualResult = solution.findPeakElement(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
