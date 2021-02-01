package com.leetcode.math.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ArmstrongNumber_1134Test {

  private final ArmstrongNumber_1134 solution = new ArmstrongNumber_1134();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(153, true), arguments(123, false), arguments(2, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isArmstrong(int num, boolean expectedResult) {
    boolean actualResult = solution.isArmstrong(num);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
