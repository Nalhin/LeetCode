package com.leetcode.tree.easy;

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

class ConvertSortedArrayToBinarySearchTree_108Test {
  private final ConvertSortedArrayToBinarySearchTree_108 solution =
      new ConvertSortedArrayToBinarySearchTree_108();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {-10, -3, 0, 5, 9}, BinaryTree.of(0, -10, 5, null, -3,null, 9)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void sortedArrayToBST(int[] arr, TreeNode expectedResult) {
    TreeNode actualResult = solution.sortedArrayToBST(arr);

    assertThatBinaryTree(actualResult).isEqualTo(expectedResult);
  }
}
