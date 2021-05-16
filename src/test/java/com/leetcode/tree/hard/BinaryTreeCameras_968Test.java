package com.leetcode.tree.hard;

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

class BinaryTreeCameras_968Test {
  private final BinaryTreeCameras_968 solution = new BinaryTreeCameras_968();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(0, 0, null, 0, 0), 1),
          arguments(BinaryTree.of(0, 0, null, 0, null, 0, null, null, 0), 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minCameraCover(TreeNode root, int expectedResult) {
    int actualResult = solution.minCameraCover(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
