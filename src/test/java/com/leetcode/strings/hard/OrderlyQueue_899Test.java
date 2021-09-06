package com.leetcode.strings.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class OrderlyQueue_899Test {
  private final OrderlyQueue_899 solution = new OrderlyQueue_899();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("cba", 1, "acb"), arguments("baaca", 3, "aaabc"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void orderlyQueue(String str, int k, String expectedResult) {
    String actualResult = solution.orderlyQueue(str, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
