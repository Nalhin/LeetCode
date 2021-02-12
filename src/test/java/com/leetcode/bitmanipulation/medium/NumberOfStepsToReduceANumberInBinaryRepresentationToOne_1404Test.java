package com.leetcode.bitmanipulation.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfStepsToReduceANumberInBinaryRepresentationToOne_1404Test {

  private final NumberOfStepsToReduceANumberInBinaryRepresentationToOne_1404 solution =
      new NumberOfStepsToReduceANumberInBinaryRepresentationToOne_1404();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("1101", 6), arguments("10", 1), arguments("1", 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numSteps(String str, int expectedResult) {
    int actualResult = solution.numSteps(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
