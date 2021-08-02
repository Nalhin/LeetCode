package com.leetcode.graph.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AlienDictionary_269Test {

  private final AlienDictionary_269 solution = new AlienDictionary_269();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new String[] {"wrt", "wrf", "er", "ett", "rftt"}, "wertf"),
          arguments(new String[] {"z", "x"}, "zx"),
          arguments(new String[] {"z", "x", "z"}, ""));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void alienOrder(String[] words, String expectedResult) {
    String actualResult = solution.alienOrder(words);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
