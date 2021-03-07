package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ElementAppearingMoreThan25InSortedArray_1287Test {

  private final ElementAppearingMoreThan25InSortedArray_1287 solution =
      new ElementAppearingMoreThan25InSortedArray_1287();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 2, 6, 6, 6, 6, 7, 10}, 6), arguments(new int[] {1}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findSpecialInteger(int[] nums, int expectedResult) {
    int actualResult = solution.findSpecialInteger(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
