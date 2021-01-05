package com.leetcode.linkedlists.medium;

import com.leetcode.utils.LinkedList;
import com.leetcode.utils.LinkedList.ListNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NextGreaterNodeInLinkedList_1019Test {
  private final NextGreaterNodeInLinkedList_1019 solution = new NextGreaterNodeInLinkedList_1019();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(LinkedList.of(2, 1, 5), new int[] {5, 5, 0}),
          arguments(LinkedList.of(2, 7, 4, 3, 5), new int[] {7, 0, 5, 5, 0}),
          arguments(LinkedList.of(1, 7, 5, 1, 9, 2, 5, 1), new int[] {7, 9, 9, 9, 0, 5, 0, 0}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void nextLargerNodes(ListNode input, int[] expectedResult) {
    int[] actualResult = solution.nextLargerNodes(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
