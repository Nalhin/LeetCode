package com.leetcode.tree.medium;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SumOfNodesWithEvenValuedGrandparent_1315Test {

  private final SumOfNodesWithEvenValuedGrandparent_1315 solution =
      new SumOfNodesWithEvenValuedGrandparent_1315();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5), 18),
          arguments(BinaryTree.empty(), 0),
          arguments(BinaryTree.of(1, 1, 1), 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void sumEvenGrandparent(TreeNode root, int expectedResult) {
    int actualResult = solution.sumEvenGrandparent(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
