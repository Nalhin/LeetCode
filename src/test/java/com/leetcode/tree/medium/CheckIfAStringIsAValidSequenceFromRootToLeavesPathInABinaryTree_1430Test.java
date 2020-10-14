package com.leetcode.tree.medium;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree_1430Test {

  private final CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree_1430 solution =
      new CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree_1430();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              BinaryTree.of(0, 1, 0, 0, 1, 0, null, null, 1, 0, 0), new int[] {0, 1, 0, 1}, true),
          arguments(
              BinaryTree.of(0, 1, 0, 0, 1, 0, null, null, 1, 0, 0), new int[] {0, 0, 1}, false),
          arguments(
              BinaryTree.of(0, 1, 0, 0, 1, 0, null, null, 1, 0, 0), new int[] {0, 1, 1}, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isValidSequence(TreeNode root, int[] array, boolean expectedResult) {
    boolean actualResult = solution.isValidSequence(root, array);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
