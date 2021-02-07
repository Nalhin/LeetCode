package com.leetcode.hashtable.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KeyboardRow_500Test {

  private final KeyboardRow_500 solution = new KeyboardRow_500();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new String[] {"Hello", "Alaska", "Dad", "Peace"}, new String[] {"Alaska", "Dad"}),
          arguments(new String[] {"omk"}, new String[] {}),
          arguments(new String[] {"adsdf", "sfd"}, new String[] {"adsdf", "sfd"}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findWords(String[] words, String[] expectedResult) {
    String[] actualResult = solution.findWords(words);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
