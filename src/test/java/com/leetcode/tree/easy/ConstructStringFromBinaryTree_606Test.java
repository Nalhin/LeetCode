package com.leetcode.tree.easy;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ConstructStringFromBinaryTree_606Test {

  private final ConstructStringFromBinaryTree_606 solution =
      new ConstructStringFromBinaryTree_606();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(1, 2, 3, null, 4), "1(2()(4))(3)"),
          arguments(BinaryTree.of(1, 2, 3, 4), "1(2(4))(3)"),
          arguments(
              BinaryTree.of(1, null, 2, null, 3, null, 4, null, 5, null, 6),
              "1()(2()(3()(4()(5()(6)))))"),
          arguments(BinaryTree.empty(), ""));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void tree2str(TreeNode root, String expectedResult) {
    String actualResult = solution.tree2str(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
