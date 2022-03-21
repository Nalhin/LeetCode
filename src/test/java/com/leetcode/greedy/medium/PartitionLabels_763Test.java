package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PartitionLabels_763Test {

  private final PartitionLabels_763 solution = new PartitionLabels_763();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("ababcbacadefegdehijhklij", List.of(9, 7, 8)),
          arguments("eccbbbbdec", List.of(10)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void partitionLabels(String n, List<Integer> expectedResult) {
    List<Integer> actualResult = solution.partitionLabels(n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
