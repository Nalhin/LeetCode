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

class SummaryRanges_228Test {

  private final SummaryRanges_228 solution = new SummaryRanges_228();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {0, 1, 2, 4, 5, 7}, List.of("0->2", "4->5", "7")),
          arguments(new int[] {0, 2, 3, 4, 6, 8, 9}, List.of("0", "2->4", "6", "8->9")),
          arguments(new int[] {}, Collections.emptyList()),
          arguments(new int[] {-1}, List.of("-1")));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void summaryRanges(int[] input, List<String> expectedResult) {
    List<String> actualResult = solution.summaryRanges(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
