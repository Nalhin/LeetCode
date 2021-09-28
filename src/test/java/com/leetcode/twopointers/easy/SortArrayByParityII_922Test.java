package com.leetcode.twopointers.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SortArrayByParityII_922Test {

  private final SortArrayByParityII_922 solution = new SortArrayByParityII_922();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(new int[] {4, 2, 5, 7}, List.of(0, 1, 0, 1)),
          arguments(new int[] {2, 3}, List.of(0, 1)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void sortArrayByParityII(int[] arr, List<Integer> mods) {
    int[] actualResult = solution.sortArrayByParityII(arr);

    assertThat(Arrays.stream(actualResult).mapToObj(e -> e % 2).collect(Collectors.toList()))
        .isEqualTo(mods);
  }
}
