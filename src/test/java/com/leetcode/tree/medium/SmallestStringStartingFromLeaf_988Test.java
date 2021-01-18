package com.leetcode.tree.medium;

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

class SmallestStringStartingFromLeaf_988Test {

  private final SmallestStringStartingFromLeaf_988 solution =
      new SmallestStringStartingFromLeaf_988();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(0, 1, 2, 3, 4, 3, 4), "dba"),
          arguments(BinaryTree.of(25, 1, 3, 1, 3, 0, 2), "adz"),
          arguments(BinaryTree.of(2, 2, 1, null, 1, 0, null, 0), "abc"),
          arguments(BinaryTree.of(2, 2, 1, null, 1, 0, null, 0), "abc"),
          arguments(BinaryTree.of(0, null, 1), "ba"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void smallestFromLeaf(TreeNode root, String expectedResult) {
    String actualResult = solution.smallestFromLeaf(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
