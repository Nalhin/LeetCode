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

class InsertIntoASortedCircularLinkedList_708Test {

  InsertIntoASortedCircularLinkedList_708 solution = new InsertIntoASortedCircularLinkedList_708();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(LinkedList.of(3, 4, 1), 2, LinkedList.of(3, 4, 1, 2)),
          arguments(LinkedList.empty(), 1, LinkedList.of(1)),
          arguments(LinkedList.of(1), 0, LinkedList.of(1, 0)),
          arguments(LinkedList.of(3, 3, 5), 0, LinkedList.of(3, 3, 5, 0)),
          arguments(LinkedList.of(1, 3, 5), 6, LinkedList.of(1, 3, 5, 6)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void detectCycleHashSetSolution(ListNode head, int value, ListNode expectedResult) {

    ListNode result = solution.insert(LinkedList.addCycle(head, 0), value);

    assertThatLinkedList(result).isEqualToIgnoringCycles(expectedResult);
  }
}
