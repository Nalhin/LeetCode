package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MissingRanges_163Test {

  private final MissingRanges_163 solution = new MissingRanges_163();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {0, 1, 3, 50, 75}, 0, 99, List.of("2", "4->49", "51->74", "76->99")),
          arguments(new int[] {}, 1, 1, List.of("1")),
          arguments(new int[] {}, -3, -1, List.of("-3->-1")),
          arguments(new int[] {-1}, -1, -1, Collections.emptyList()),
          arguments(new int[] {-1}, -2, -1, List.of("-2")),
          arguments(new int[] {7}, 0, 9, List.of("0->6", "8->9")));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void missingNumber(int[] nums, int lower, int upper, List<String> expectedResult) {
    List<String> actualResult = solution.findMissingRanges(nums, lower, upper);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
