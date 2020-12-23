package com.leetcode.tree.medium;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import com.leetcode.utils.LinkedList.ListNode;
import com.leetcode.utils.LinkedList;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LinkedListInABinaryTree_1367Test {
  private final LinkedListInABinaryTree_1367 solution = new LinkedListInABinaryTree_1367();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              LinkedList.of(4, 2, 8),
              BinaryTree.of(1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3),
              true),
          arguments(
              LinkedList.of(1, 4, 2, 6),
              BinaryTree.of(1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3),
              true),
          arguments(
              LinkedList.of(1, 4, 2, 6, 8),
              BinaryTree.of(1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3),
              false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isSubPath(ListNode head, TreeNode root, boolean expectedResult) {
    boolean actualResult = solution.isSubPath(head, root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
