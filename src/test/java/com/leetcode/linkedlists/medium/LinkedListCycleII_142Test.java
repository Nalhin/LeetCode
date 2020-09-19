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

class LinkedListCycleII_142Test {

  LinkedListCycleII_142.HashSetSolution hashSetSolution = new LinkedListCycleII_142.HashSetSolution();
  LinkedListCycleII_142.TwoPointerSolution twoPointerSolution = new LinkedListCycleII_142.TwoPointerSolution();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(LinkedList.of(3, 2, 0, -4), 1),
          arguments(LinkedList.of(1, 2), 0),
          arguments(LinkedList.of(1, 2), -1),
          arguments(LinkedList.empty(), -1),
          arguments(LinkedList.of(1), -1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void detectCycleHashSetSolution(ListNode input, int cycleIndex) {

    ListNode result = hashSetSolution.detectCycle(LinkedList.addCycle(input, cycleIndex));

    assertThatLinkedList(input).hasCycleAtPosition(result, cycleIndex);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void detectCycleTwoPointerSolution(ListNode input, int cycleIndex) {

    ListNode result = twoPointerSolution.detectCycle(LinkedList.addCycle(input, cycleIndex));

    assertThatLinkedList(input).hasCycleAtPosition(result, cycleIndex);
  }
}
