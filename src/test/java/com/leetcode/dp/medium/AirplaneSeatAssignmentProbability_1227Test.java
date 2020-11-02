package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AirplaneSeatAssignmentProbability_1227Test {

  private final AirplaneSeatAssignmentProbability_1227.Dp solutionDp =
      new AirplaneSeatAssignmentProbability_1227.Dp();

  private final AirplaneSeatAssignmentProbability_1227.TrickySolution solutionTricky =
      new AirplaneSeatAssignmentProbability_1227.TrickySolution();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(1, 1.0), arguments(2, 0.5), arguments(99, 0.5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void nthPersonGetsNthSeatDp(int n, double expectedResult) {

    double actualResult = solutionDp.nthPersonGetsNthSeat(n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void nthPersonGetsNthSeatTricky(int n, double expectedResult) {

    double actualResult = solutionTricky.nthPersonGetsNthSeat(n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
