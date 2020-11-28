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

class SerializeAndDeserializeBST_449Test {

  private final SerializeAndDeserializeBST_449 solution = new SerializeAndDeserializeBST_449();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(2, 1, 3)),
          arguments(BinaryTree.empty()),
          arguments(BinaryTree.of(0, 1, 0, 0, 1, 0, null, null, 1, 0, 0)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void serializeAndDeserialize(TreeNode expectedResult) {
    TreeNode actualResult = solution.deserialize(solution.serialize(expectedResult));

    assertThatBinaryTree(actualResult).isEqualTo(expectedResult);
  }
}
