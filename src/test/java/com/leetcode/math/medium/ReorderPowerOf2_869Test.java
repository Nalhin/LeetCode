package com.leetcode.math.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReorderPowerOf2_869Test {
  private final ReorderPowerOf2_869 solution = new ReorderPowerOf2_869();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(1, true),
          arguments(10, false),
          arguments(16, true),
          arguments(24, false),
          arguments(46, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void reorderedPowerOf2(int target, boolean expectedResult) {
    boolean actualResult = solution.reorderedPowerOf2(target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
