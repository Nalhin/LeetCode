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

class FindAndReplacePattern_890Test {

  private final FindAndReplacePattern_890 solution = new FindAndReplacePattern_890();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new String[] {"deq", "mee", "aqq", "dkd", "ccc", "qqa"},
              "abb",
              List.of("mee", "aqq")));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findAndReplacePattern(String[] words, String pattern, List<String> expectedResult) {
    List<String> actualResult = solution.findAndReplacePattern(words, pattern);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
