package com.leetcode.arrays.medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KeysAndRooms_841Test {

  private final KeysAndRooms_841 solution = new KeysAndRooms_841();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(List.of(List.of(1), List.of(2), List.of(3), Collections.emptyList()), true),
          arguments(List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0)), false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void canVisitAllRooms(List<List<Integer>> input, boolean expectedResult) {

    boolean actualResult = solution.canVisitAllRooms(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
