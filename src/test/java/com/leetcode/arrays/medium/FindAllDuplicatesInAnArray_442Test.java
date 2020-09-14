package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindAllDuplicatesInAnArray_442Test {

  FindAllDuplicatesInAnArray_442 solution = new FindAllDuplicatesInAnArray_442();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(new int[] {4, 3, 2, 7, 8, 2, 3, 1}, List.of(2, 3)),
          arguments(new int[] {1, 2, 1, 2, 3}, List.of(1, 2)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findDuplicates(int[] input, List<Integer> expected) {

    List<Integer> result = solution.findDuplicates(input);

    assertThat(result).isEqualTo(expected);
  }
}
