package com.leetcode.tree.easy;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BinaryTreePaths_257Test {

  private final BinaryTreePaths_257 solution = new BinaryTreePaths_257();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.empty(), Collections.emptyList()),
          arguments(BinaryTree.of(1), List.of("1")),
          arguments(BinaryTree.of(1, 2, 3, null, 5), List.of("1->2->5", "1->3")));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void binaryTreePaths(TreeNode root, List<String> expectedResult) {
    List<String> actualResult = solution.binaryTreePaths(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
