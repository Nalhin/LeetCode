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

class FindAllAnagramsInAString_438Test {

  private final FindAllAnagramsInAString_438 solution = new FindAllAnagramsInAString_438();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("cbaebabacd", "abc", List.of(0, 6)), arguments("abab", "ab", List.of(0, 1, 2)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findAnagrams(String s, String p, List<Integer> expectedResult) {
    List<Integer> actualResult = solution.findAnagrams(s, p);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
