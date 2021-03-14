package com.leetcode.linkedlists.medium;

import com.leetcode.utils.LinkedList;
import com.leetcode.utils.LinkedList.ListNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static com.leetcode.assertions.LinkedListAssertions.assertThatLinkedList;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SwappingNodesInALinkedList_1721Test {
  private final SwappingNodesInALinkedList_1721 solution = new SwappingNodesInALinkedList_1721();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(LinkedList.of(1, 2, 3, 4, 5), 2, LinkedList.of(1, 4, 3, 2, 5)),
          arguments(
              LinkedList.of(7, 9, 6, 6, 7, 8, 3, 0, 9, 5),
              5,
              LinkedList.of(7, 9, 6, 6, 8, 7, 3, 0, 9, 5)),
          arguments(LinkedList.of(1), 1, LinkedList.of(1)),
          arguments(LinkedList.of(1, 2), 1, LinkedList.of(2, 1)),
          arguments(LinkedList.of(1, 2, 3), 2, LinkedList.of(1, 2, 3)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void swapNodes(ListNode input, int k, ListNode expectedResult) {
    ListNode actualResult = solution.swapNodes(input, k);

    assertThatLinkedList(actualResult).isEqualTo(expectedResult);
  }
}
