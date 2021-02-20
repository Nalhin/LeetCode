package com.leetcode.math.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RobotBoundedInCircle_1041Test {
  private final RobotBoundedInCircle_1041 solution = new RobotBoundedInCircle_1041();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("GGLLGG", true), arguments("GG", false), arguments("GL", true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isRobotBounded(String instructions, boolean expectedResult) {
    boolean actualResult = solution.isRobotBounded(instructions);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
