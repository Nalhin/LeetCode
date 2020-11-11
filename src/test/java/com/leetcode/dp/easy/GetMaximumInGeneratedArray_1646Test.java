package com.leetcode.dp.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GetMaximumInGeneratedArray_1646Test {

  private final GetMaximumInGeneratedArray_1646 solution = new GetMaximumInGeneratedArray_1646();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(7, 3), arguments(2, 1), arguments(3, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void getMaximumGenerated(int n, int expectedResult) {
    int actualResult = solution.getMaximumGenerated(n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
