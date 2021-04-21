package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CheckIfTheSentenceIsPangram_1832Test {
  private final CheckIfTheSentenceIsPangram_1832 solution = new CheckIfTheSentenceIsPangram_1832();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("thequickbrownfoxjumpsoverthelazydog", true), arguments("leetcode", false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void checkIfPangram(String sentence, boolean expectedResult) {
    boolean actualResult = solution.checkIfPangram(sentence);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
