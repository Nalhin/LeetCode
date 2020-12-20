package com.leetcode.tree.medium;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static com.leetcode.assertions.BinaryTreeAssertions.assertThatBinaryTree;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumBinaryTree_654Test {

  private final MaximumBinaryTree_654 solution = new MaximumBinaryTree_654();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[] {3, 2, 1, 6, 0, 5}, BinaryTree.of(6, 3, 5, null, 2, 0, null, null, 1)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void constructMaximumBinaryTree(int[] nums, TreeNode expectedResult) {
    TreeNode actualResult = solution.constructMaximumBinaryTree(nums);

    assertThatBinaryTree(actualResult).isEqualTo(expectedResult);
  }
}
