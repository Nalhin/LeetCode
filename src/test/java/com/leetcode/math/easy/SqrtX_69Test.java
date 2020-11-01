package com.leetcode.math.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SqrtX_69Test {

  private final SqrtX_69 solution = new SqrtX_69();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
//          arguments(4, 2),
//          arguments(8, 2),
//          arguments(1, 1),
          arguments(85, 9),
          arguments(2147395599, 46339));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void mySqrt(int x, int expectedResult) {
    int actualResult = solution.mySqrt(x);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
