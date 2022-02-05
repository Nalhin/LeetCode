package com.leetcode.hashtable.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindAllLonelyNumbersInTheArray_2150Test {

  private final FindAllLonelyNumbersInTheArray_2150 solution =
      new FindAllLonelyNumbersInTheArray_2150();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {10, 6, 5, 8}, List.of(10, 8)),
          arguments(new int[] {1, 3, 5, 3}, List.of(1, 5)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findLonely(int[] nums, List<Integer> expectedResult) {
    List<Integer> actualResult = solution.findLonely(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
