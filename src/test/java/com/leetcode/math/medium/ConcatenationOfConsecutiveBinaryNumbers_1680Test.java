package com.leetcode.math.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ConcatenationOfConsecutiveBinaryNumbers_1680Test {

  private final ConcatenationOfConsecutiveBinaryNumbers_1680 solution =
      new ConcatenationOfConsecutiveBinaryNumbers_1680();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(1, 1), arguments(3, 27), arguments(12, 505379714));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void concatenatedBinary(int k, int expectedResult) {
    int actualResult = solution.concatenatedBinary(k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
