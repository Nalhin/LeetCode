package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FizzBuzz_412Test {

  private final FizzBuzz_412 solution = new FizzBuzz_412();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(1, List.of("1")),
          arguments(
              15,
              List.of(
                  "1",
                  "2",
                  "Fizz",
                  "4",
                  "Buzz",
                  "Fizz",
                  "7",
                  "8",
                  "Fizz",
                  "Buzz",
                  "11",
                  "Fizz",
                  "13",
                  "14",
                  "FizzBuzz")));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void fizzBuzz(int input, List<String> expectedResult) {

    List<String> result = solution.fizzBuzz(input);

    assertThat(result).isEqualTo(expectedResult);
  }
}
