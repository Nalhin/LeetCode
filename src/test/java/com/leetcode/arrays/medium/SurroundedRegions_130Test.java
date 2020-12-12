package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SurroundedRegions_130Test {

  private final SurroundedRegions_130 solution = new SurroundedRegions_130();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new char[][] {{'X'}}, new char[][] {{'X'}}),
          arguments(new char[][] {}, new char[][] {}),
          arguments(new char[][] {{}}, new char[][] {{}}),
          arguments(
              new char[][] {
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}
              },
              new char[][] {
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}
              }),
          arguments(
              new char[][] {{'O', 'X', 'O'}, {'X', 'O', 'X'}, {'O', 'X', 'O'}},
              new char[][] {{'O', 'X', 'O'}, {'X', 'X', 'X'}, {'O', 'X', 'O'}}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void solve(char[][] input, char[][] expectedResult) {
    solution.solve(input);

    assertThat(input).isEqualTo(expectedResult);
  }
}
