package com.leetcode.math.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ComplexNumberManipulation_537Test {

  private final ComplexNumberManipulation_537 solution = new ComplexNumberManipulation_537();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("1+1i", "1+1i", "0+2i"), arguments("1+-1i", "1+-1i", "0+-2i"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void complexNumberMultiply(String first, String second, String expectedResult) {
    String actualResult = solution.complexNumberMultiply(first, second);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
