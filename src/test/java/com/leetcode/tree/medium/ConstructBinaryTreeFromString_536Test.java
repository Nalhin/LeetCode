package com.leetcode.tree.medium;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static com.leetcode.assertions.BinaryTreeAssertions.assertThatBinaryTree;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ConstructBinaryTreeFromString_536Test {

  private final ConstructBinaryTreeFromString_536 solution =
      new ConstructBinaryTreeFromString_536();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("4(2(3)(1))(6(5))", BinaryTree.of(4, 2, 6, 3, 1, 5)),
          arguments("4(2(3)(1))(6(5)(7))", BinaryTree.of(4, 2, 6, 3, 1, 5, 7)),
          arguments("-4(2(3)(1))(6(5)(7))", BinaryTree.of(-4, 2, 6, 3, 1, 5, 7)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void str2tree(String str, TreeNode expectedResult) {
    TreeNode actualResult = solution.str2tree(str);

    assertThatBinaryTree(actualResult).isEqualTo(expectedResult);
  }
}
