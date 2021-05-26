package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PartitioningIntoMinimumNumberOfDeciBinaryNumbers_1689Test {

  private final PartitioningIntoMinimumNumberOfDeciBinaryNumbers_1689 solution =
      new PartitioningIntoMinimumNumberOfDeciBinaryNumbers_1689();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("32", 3), arguments("82734", 8), arguments("27346209830709182346", 9));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minPartitions(String n, int expectedResult) {
    int actualResult = solution.minPartitions(n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
