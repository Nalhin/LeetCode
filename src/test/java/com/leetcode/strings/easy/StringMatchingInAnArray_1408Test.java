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

class StringMatchingInAnArray_1408Test {

  private final StringMatchingInAnArray_1408 solution = new StringMatchingInAnArray_1408();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(new String[] {"mass", "as", "hero", "superhero"}, List.of("as", "hero")),
          arguments(new String[] {"leetcode", "et", "code"}, List.of("et", "code")),
          arguments(new String[] {"blue", "green", "bu"}, Collections.emptyList()));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void stringMatching(String[] words, List<String> expectedResult) {
    List<String> actualResult = solution.stringMatching(words);

    assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
  }
}
