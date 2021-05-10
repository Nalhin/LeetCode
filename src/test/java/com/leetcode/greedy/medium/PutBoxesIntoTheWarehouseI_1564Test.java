package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PutBoxesIntoTheWarehouseI_1564Test {

  private final PutBoxesIntoTheWarehouseI_1564 solution = new PutBoxesIntoTheWarehouseI_1564();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {4, 3, 4, 1}, new int[] {5, 3, 3, 4, 1}, 3),
          arguments(new int[] {1, 2, 2, 3, 4}, new int[] {3, 4, 1, 2}, 3),
          arguments(new int[] {1, 2, 3}, new int[] {1, 2, 3, 4}, 1),
          arguments(new int[] {4, 5, 6}, new int[] {3, 3, 3, 3, 3}, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxBoxesInWarehouse(int[] boxes, int[] warehouse, int expectedResult) {
    int actualResult = solution.maxBoxesInWarehouse(boxes, warehouse);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
