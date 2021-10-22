package com.leetcode.sort.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SortCharactersByFrequency_451Test {

  private final SortCharactersByFrequency_451 solution = new SortCharactersByFrequency_451();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("tree", "eert"),
          arguments("ccccaaa", "ccccaaa"),
          arguments("Aaabbb", "bbbaaA"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void frequencySort(String str, String expectedResult) {
    String actualResult = solution.frequencySort(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
