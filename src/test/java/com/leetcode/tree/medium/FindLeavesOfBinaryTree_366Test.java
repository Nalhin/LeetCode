package com.leetcode.tree.medium;

import com.leetcode.utils.BinaryTree;
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

class FindLeavesOfBinaryTree_366Test {

  private final FindLeavesOfBinaryTree_366 solution = new FindLeavesOfBinaryTree_366();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              BinaryTree.of(1, 2, 3, 4, 5), List.of(List.of(4, 5, 3), List.of(2), List.of(1))),
          arguments(BinaryTree.of(1, 3), List.of(List.of(3), List.of(1))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findLeaves(BinaryTree.TreeNode input, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solution.findLeaves(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
