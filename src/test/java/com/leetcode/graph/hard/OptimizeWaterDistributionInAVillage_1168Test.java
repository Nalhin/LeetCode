package com.leetcode.graph.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class OptimizeWaterDistributionInAVillage_1168Test {

  private final OptimizeWaterDistributionInAVillage_1168.Prim solutionPrim =
      new OptimizeWaterDistributionInAVillage_1168.Prim();
  private final OptimizeWaterDistributionInAVillage_1168.Kruskal solutionKruskal =
      new OptimizeWaterDistributionInAVillage_1168.Kruskal();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(3, new int[] {1, 2, 2}, new int[][] {{1, 2, 1}, {2, 3, 1}}, 3));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minCostToSupplyWaterPrim(int n, int[] wells, int[][] pipes, int expectedResult) {
    int actualResult = solutionPrim.minCostToSupplyWater(n, wells, pipes);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minCostToSupplyWaterKruskal(int n, int[] wells, int[][] pipes, int expectedResult) {
    int actualResult = solutionKruskal.minCostToSupplyWater(n, wells, pipes);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
