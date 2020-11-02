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

class InsertionSortList_147Test {

  private final InsertionSortList_147 solution = new InsertionSortList_147();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(LinkedList.of(4, 2, 1, 3), LinkedList.of(1, 2, 3, 4)),
          arguments(LinkedList.empty(), LinkedList.empty()),
          arguments(LinkedList.of(1), LinkedList.of(1)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void insertionSortList(ListNode head, ListNode expectedResult) {

    ListNode result = solution.insertionSortList(head);

    assertThatLinkedList(result).isEqualToIgnoringCycles(expectedResult);
  }
}
