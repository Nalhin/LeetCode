package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PushDominoes_838Test {
  private final PushDominoes_838 solution = new PushDominoes_838();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("RR.L", "RR.L"), arguments(".L.R...LR..L..", "LL.RR.LLRRLL.."));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void pushDominoes(String string, String expectedResult) {
    String actualResult = solution.pushDominoes(string);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
