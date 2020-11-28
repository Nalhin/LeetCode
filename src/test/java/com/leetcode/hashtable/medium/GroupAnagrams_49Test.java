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

class GroupAnagrams_49Test {
  private final GroupAnagrams_49 solution = new GroupAnagrams_49();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new String[] {"eat", "tea", "tan", "ate", "nat", "bat"},
              List.of(List.of("bat"), List.of("nat", "tan"), List.of("eat", "tea", "ate"))),
          arguments(new String[] {""}, List.of(List.of(""))),
          arguments(new String[] {"a"}, List.of(List.of("a"))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void firstUniqChar(String[] strs, List<List<String>> expectedResult) {

    List<List<String>> actualResult = solution.groupAnagrams(strs);

    assertThat(actualResult).hasSize(expectedResult.size());
  }
}
