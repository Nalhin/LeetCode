package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindAllNumbersDisappearedInAnArray_448Test {

  private final FindAllNumbersDisappearedInAnArray_448 solution = new FindAllNumbersDisappearedInAnArray_448();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(new int[] {4, 3, 2, 7, 8, 2, 3, 1}, List.of(5, 6)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findDisappearedNumbers(int[] input, List<Integer> expectedResult) {

    List<Integer> actualResult = solution.findDisappearedNumbers(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
