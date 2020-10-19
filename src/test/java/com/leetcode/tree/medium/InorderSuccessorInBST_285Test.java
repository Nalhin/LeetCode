package com.leetcode.tree.medium;

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

class InorderSuccessorInBST_285Test {

  private final InorderSuccessorInBST_285 solution = new InorderSuccessorInBST_285();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(2, 1, 3), new TreeNode(1), 2),
          arguments(BinaryTree.of(5, 3, 6, 2, 4, null, null, 1), new TreeNode(6), null));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void inorderSuccessor(TreeNode root, TreeNode val, Integer expectedResult) {
    TreeNode actualResult = solution.inorderSuccessor(root, val);

    assertThat(actualResult == null ? null : actualResult.val).isEqualTo(expectedResult);
  }
}
