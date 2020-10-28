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

class FindAllTheLonelyNodes_1469Test {

  private final FindAllTheLonelyNodes_1469 solution = new FindAllTheLonelyNodes_1469();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(1, 2, 3, null, 4), List.of(4)),
          arguments(
              BinaryTree.of(7, 1, 4, 6, null, 5, 3, null, null, null, null, null, 2),
              List.of(6, 2)),
          arguments(
              BinaryTree.of(11, 99, 88, 77, null, null, 66, 55, null, null, 44, 33, null, null, 22),
              List.of(77, 55, 33, 66, 44, 22)),
          arguments(BinaryTree.of(197), Collections.emptyList()));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void getLonelyNodes(TreeNode root, List<Integer> expectedResult) {
    List<Integer> actualResult = solution.getLonelyNodes(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
