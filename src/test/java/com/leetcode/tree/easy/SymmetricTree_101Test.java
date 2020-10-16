package com.leetcode.tree.easy;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SymmetricTree_101Test {

  private final SymmetricTree_101.Iterative solutionIterative = new SymmetricTree_101.Iterative();

  private final SymmetricTree_101.Recursive solutionRecursive = new SymmetricTree_101.Recursive();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.empty(), true),
          arguments(BinaryTree.of(1), true),
          arguments(BinaryTree.of(1, 2, 2, 3, 4, 4, 3), true),
          arguments(BinaryTree.of(1, 2, 2, null, 3, null, 3), false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void levelOrderIterative(TreeNode root, boolean expectedResult) {
    boolean actualResult = solutionIterative.isSymmetric(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void levelOrderRecursive(TreeNode root, boolean expectedResult) {
    boolean actualResult = solutionRecursive.isSymmetric(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
