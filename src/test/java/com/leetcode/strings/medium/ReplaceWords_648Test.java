package com.leetcode.strings.medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReplaceWords_648Test {

  private final ReplaceWords_648 solution = new ReplaceWords_648();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              List.of("cat", "bat", "rat"),
              "the cattle was rattled by the battery",
              "the cat was rat by the bat"),
          arguments(List.of("a", "b", "c"), "aadsfasf absbs bbab cadsfafs", "a a b c"),
          arguments(
              List.of("a", "aa", "aaa", "aaaa"),
              "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa",
              "a a a a a a a a bbb baba a"),
          arguments(
              List.of("catt", "cat", "bat", "rat"),
              "the cattle was rattled by the battery",
              "the cat was rat by the bat"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void replaceWords(List<String> dictionary, String sentence, String expectedResult) {
    String actualResult = solution.replaceWords(dictionary, sentence);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
