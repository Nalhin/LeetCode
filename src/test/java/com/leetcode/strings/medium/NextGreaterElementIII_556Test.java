package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NextGreaterElementIII_556Test {

  private final NextGreaterElementIII_556 solution = new NextGreaterElementIII_556();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(12, 21),
          arguments(21, -1),
          arguments(12213213, 12213231),
          arguments(32142344, 32142434));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void nextGreaterElement(int num, int expectedResult) {
    int actualResult = solution.nextGreaterElement(num);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
