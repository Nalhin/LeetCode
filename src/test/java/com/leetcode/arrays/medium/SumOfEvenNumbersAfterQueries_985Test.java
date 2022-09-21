package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SumOfEvenNumbersAfterQueries_985Test {
  private final SumOfEvenNumbersAfterQueries_985 solution = new SumOfEvenNumbersAfterQueries_985();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(new int[] {1, 2,3,4}, new int[][]{{1,0}, {-3,1}, {-4,0}, {2,3}}, new int[]{8,6,2,4}), arguments(new int[] {1}, new int[][]{{4,0}}, new int[]{0}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void sumEvenAfterQueries(int[] nums,int[][] queries,  int[] expectedResult) {

    int[] actualResult = solution.sumEvenAfterQueries(nums, queries);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}