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

class FindBottomLeftTreeValue_513Test {

  private final FindBottomLeftTreeValue_513 solution = new FindBottomLeftTreeValue_513();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(2, 1, 3), 1),
          arguments(BinaryTree.of(1, 2, 3, 4, 5, 6, null, null, 7), 7));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findBottomLeftValue(TreeNode preorder, int expectedResult) {
    int actualResult = solution.findBottomLeftValue(preorder);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
