package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestWordInDictionaryThroughDeleting_524Test {

  private final LongestWordInDictionaryThroughDeleting_524 solution =
      new LongestWordInDictionaryThroughDeleting_524();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("abpcplea", new String[] {"ale", "apple", "monkey", "plea"}, "apple"),
          arguments("abpcpleoa", new String[] {"a", "b", "c"}, "a"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findLongestWord(String input, List<String> words, String expectedResult) {
    String actualResult = solution.findLongestWord(input, words);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
