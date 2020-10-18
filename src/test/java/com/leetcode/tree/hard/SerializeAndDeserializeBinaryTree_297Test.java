package com.leetcode.tree.hard;

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

class SerializeAndDeserializeBinaryTree_297Test {

  private final SerializeAndDeserializeBinaryTree_297.Codec solution =
      new SerializeAndDeserializeBinaryTree_297.Codec();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.empty()),
          arguments(BinaryTree.of(5, 14, null, 1)),
          arguments(BinaryTree.of(1)),
          arguments(BinaryTree.of(1)),
          arguments(BinaryTree.of(1, 2)),
          arguments(BinaryTree.of(3, 9, 20, null, null, 15, 7)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void averageOfLevels(TreeNode root) {
    TreeNode actualResult = solution.deserialize(solution.serialize(root));

    assertThatBinaryTree(actualResult).isEqualTo(root);
  }
}
