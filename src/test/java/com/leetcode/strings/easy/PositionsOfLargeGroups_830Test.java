package com.leetcode.strings.easy;

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

class PositionsOfLargeGroups_830Test {
  private final PositionsOfLargeGroups_830 solution = new PositionsOfLargeGroups_830();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("abbxxxxzzy", List.of(List.of(3, 6))),
          arguments("abc", Collections.emptyList()),
          arguments("abcdddeeeeaabbbcd", List.of(List.of(3, 5), List.of(6, 9), List.of(12, 14))),
          arguments("aba", Collections.emptyList()));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void largeGroupPositions(String str, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solution.largeGroupPositions(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
