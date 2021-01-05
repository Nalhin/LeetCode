package com.leetcode.greedy.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class JumpGameII_45Test {

  private final JumpGameII_45 solution = new JumpGameII_45();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 3, 1, 1, 4}, 2), arguments(new int[] {2, 3, 0, 1, 4}, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void jump(int[] input, int expectedResult) {
    int actualResult = solution.jump(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
