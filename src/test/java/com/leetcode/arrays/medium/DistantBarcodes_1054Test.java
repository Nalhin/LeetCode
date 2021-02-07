package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DistantBarcodes_1054Test {
  private final DistantBarcodes_1054 solution = new DistantBarcodes_1054();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 1, 1, 2, 2, 2}, new int[] {1, 2, 1, 2, 1, 2}),
          arguments(new int[] {1, 1, 1, 1, 2, 2, 3, 3}, new int[] {1, 2, 1, 2, 1, 3, 1, 3}),
          arguments(new int[] {2, 2, 2, 1, 5}, new int[] {2, 1, 2, 5, 2}),
          arguments(new int[] {2, 2, 1, 3}, new int[] {2, 1, 2, 3}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void rearrangeBarcodes(int[] barcodes, int[] expectedResult) {
    int[] actualResult = solution.rearrangeBarcodes(barcodes);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
