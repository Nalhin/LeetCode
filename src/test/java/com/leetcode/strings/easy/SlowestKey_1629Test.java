package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SlowestKey_1629Test {
  private final SlowestKey_1629 solution = new SlowestKey_1629();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {9, 29, 49, 50}, "cbcd", 'c'),
          arguments(new int[]{12,23,36,46,62}, "spuda", 'a'));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void slowestKey(int[] releaseTimes, String keysPressed, char expectedResult) {
    char actualResult = solution.slowestKey(releaseTimes, keysPressed);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
