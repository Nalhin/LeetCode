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

class DeleteTheMiddleNodeOfALinkedList_2095Test {

  private final DeleteTheMiddleNodeOfALinkedList_2095 solution = new DeleteTheMiddleNodeOfALinkedList_2095();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(LinkedList.of(1, 3, 4, 7, 1, 2, 6), LinkedList.of(1, 3, 4, 1, 2, 6)),
          arguments(LinkedList.of(1, 2, 3, 4), LinkedList.of(1, 2, 4)),
          arguments(LinkedList.of(2, 1), LinkedList.of(2)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void deleteMiddle(ListNode head, ListNode expectedResult) {
    ListNode result = solution.deleteMiddle(head);

    assertThatLinkedList(result).isEqualTo(expectedResult);
  }

}