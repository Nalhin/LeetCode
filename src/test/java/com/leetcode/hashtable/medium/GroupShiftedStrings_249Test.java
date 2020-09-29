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

class GroupShiftedStrings_249Test {
  private final GroupShiftedStrings_249 solution = new GroupShiftedStrings_249();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new String[] {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"},
              List.of(
                  List.of("abc", "bcd", "xyz"),
                  List.of("az", "ba"),
                  List.of("acef"),
                  List.of("a", "z"))),
          arguments(new String[] {""}, List.of(List.of(""))),
          arguments(new String[] {"a"}, List.of(List.of("a"))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void groupStrings(String[] strs, List<List<String>> expectedResult) {

    List<List<String>> actualResult = solution.groupStrings(strs);

    assertThat(actualResult).hasSize(expectedResult.size());
  }
}
