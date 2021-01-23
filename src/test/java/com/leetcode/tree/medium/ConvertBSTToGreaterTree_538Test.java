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

class ConvertBSTToGreaterTree_538Test {

  private final ConvertBSTToGreaterTree_538 solution = new ConvertBSTToGreaterTree_538();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              BinaryTree.of(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8),
              BinaryTree.of(30, 36, 21, 36, 35, 26, 15, null, null, null, 33, null, null, null, 8)),
          arguments(BinaryTree.of(0, null, 1), BinaryTree.of(1, null, 1)),
          arguments(BinaryTree.of(1, 0, 2), BinaryTree.of(3, 3, 2)),
          arguments(BinaryTree.of(3, 2, 4, 1), BinaryTree.of(7, 9, 4, 10)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void convertBST(TreeNode preorder, TreeNode expectedResult) {
    TreeNode actualResult = solution.convertBST(preorder);

    assertThatBinaryTree(actualResult).isEqualTo(expectedResult);
  }
}
