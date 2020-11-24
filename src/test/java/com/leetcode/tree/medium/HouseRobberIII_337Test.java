package com.leetcode.tree.medium;

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

class HouseRobberIII_337Test {

  private final HouseRobberIII_337 solution = new HouseRobberIII_337();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(3, 2, 1, null, 3, null, 1), 7),
          arguments(BinaryTree.of(3, 4, 5, 1, 3, null, 1), 9),
          arguments(BinaryTree.of(4, 1, null, 2, null, 3), 7),
          arguments(BinaryTree.of(2, 1, 3, null, 4), 7));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void rob(TreeNode preorder, int expectedResult) {
    int actualResult = solution.rob(preorder);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
