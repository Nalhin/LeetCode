package com.leetcode.dp.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CountAllValidPickupAndDeliveryOptions_1359Test {

  private final CountAllValidPickupAndDeliveryOptions_1359 solution =
      new CountAllValidPickupAndDeliveryOptions_1359();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(1, 1), arguments(2, 6), arguments(3, 90));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countOrders(int n, int expectedResult) {
    int actualResult = solution.countOrders(n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
