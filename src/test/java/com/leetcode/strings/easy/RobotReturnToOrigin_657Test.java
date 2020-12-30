package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RobotReturnToOrigin_657Test {

  private final RobotReturnToOrigin_657 solution = new RobotReturnToOrigin_657();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("LDRRLRUULR", false),
          arguments("RRDD", false),
          arguments("LL", false),
          arguments("UD", true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void judgeCircle(String moves, boolean expectedResult) {
    boolean actualResult = solution.judgeCircle(moves);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
