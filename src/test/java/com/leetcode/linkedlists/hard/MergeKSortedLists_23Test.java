package com.leetcode.linkedlists.hard;

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

class MergeKSortedLists_23Test {

  private final MergeKSortedLists_23 solution = new MergeKSortedLists_23();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new ListNode[] {LinkedList.of(1, 4, 5), LinkedList.of(1, 3, 4), LinkedList.of(2, 6)},
              LinkedList.of(1, 1, 2, 3, 4, 4, 5, 6)),
          arguments(new ListNode[] {}, LinkedList.empty()),
          arguments(new ListNode[] {LinkedList.empty()}, LinkedList.empty()));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void mergeKLists(ListNode[] input, ListNode expectedResult) {
    ListNode actualResult = solution.mergeKLists(input);

    assertThatLinkedList(actualResult).isEqualTo(expectedResult);
  }
}
