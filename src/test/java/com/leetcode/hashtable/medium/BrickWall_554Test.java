package com.leetcode.hashtable.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BrickWall_554Test {
  private final BrickWall_554 solution = new BrickWall_554();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              List.of(
                  List.of(1, 2, 2, 1),
                  List.of(3, 1, 2),
                  List.of(1, 3, 2),
                  List.of(2, 4),
                  List.of(3, 1, 2),
                  List.of(1, 3, 1, 1)),
              2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void leastBricks(List<List<Integer>> wall, int expectedResult) {
    int actualResult = solution.leastBricks(wall);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
