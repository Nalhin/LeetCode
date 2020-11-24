package com.leetcode.hashtable.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DestinationCity_1436Test {
  private final DestinationCity_1436 solution = new DestinationCity_1436();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              List.of(
                  List.of("London", "New York"),
                  List.of("New York", "Lima"),
                  List.of("Lima", "Sao Paulo")),
              "Sao Paulo"),
          arguments(List.of(List.of("B", "C"), List.of("D", "B"), List.of("C", "A")), "A"),
          arguments(List.of(List.of("A", "Z")), "Z"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void firstUniqChar(List<List<String>> cities, String expectedResult) {
    String actualResult = solution.destCity(cities);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
