package com.leetcode.linkedlists.easy;

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

class DeleteNNodesAfterMNodesOfALinkedList_1474Test {

  private final DeleteNNodesAfterMNodesOfALinkedList_1474 solution =
      new DeleteNNodesAfterMNodesOfALinkedList_1474();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              LinkedList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13),
              2,
              3,
              LinkedList.of(1, 2, 6, 7, 11, 12)),
          arguments(LinkedList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), 1, 3, LinkedList.of(1, 5, 9)),
          arguments(
              LinkedList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
              3,
              1,
              LinkedList.of(1, 2, 3, 5, 6, 7, 9, 10, 11)),
          arguments(LinkedList.of(9, 3, 7, 7, 9, 10, 8, 2), 1, 2, LinkedList.of(9, 7, 8)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void deleteNodes(ListNode input, int m, int n, ListNode expectedResult) {
    ListNode result = solution.deleteNodes(input, m, n);

    assertThatLinkedList(result).isEqualTo(expectedResult);
  }
}
