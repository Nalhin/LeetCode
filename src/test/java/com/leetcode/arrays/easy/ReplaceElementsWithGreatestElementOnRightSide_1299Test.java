package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReplaceElementsWithGreatestElementOnRightSide_1299Test {

  private final ReplaceElementsWithGreatestElementOnRightSide_1299 solution =
      new ReplaceElementsWithGreatestElementOnRightSide_1299();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {17, 18, 5, 4, 6, 1}, new int[] {18, 6, 6, 6, 1, -1}),
          arguments(
              new int[] {32, 132, 123, 132, 132, 1332, 3, 21, 2312, 32, 1, 3, 4, 5, 6, 231, 3, 4},
              new int[] {
                2312, 2312, 2312, 2312, 2312, 2312, 2312, 2312, 231, 231, 231, 231, 231, 231, 231,
                4, 4, -1
              }),
          arguments(new int[] {17, 2, 7, 6, 4, 4}, new int[] {7, 7, 6, 4, 4, -1}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void replaceElements(int[] input, int[] expectedResult) {

    int[] actualResult = solution.replaceElements(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
