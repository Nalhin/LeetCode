package com.leetcode.twopointers.medium;

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

class ThreeSum_15Test {

  private final ThreeSum_15 solution = new ThreeSum_15();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[] {-1, 0, 1, 2, -1, -4}, List.of(List.of(-1, -1, 2), List.of(-1, 0, 1))),
          arguments(new int[0], Collections.emptyList()),
          arguments(new int[] {0}, Collections.emptyList()));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void threeSum(int[] arr, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solution.threeSum(arr);

    assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
  }
}
