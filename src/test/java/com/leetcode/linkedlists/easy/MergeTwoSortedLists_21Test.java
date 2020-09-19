package com.leetcode.linkedlists.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import com.leetcode.utils.LinkedList;
import com.leetcode.utils.LinkedList.ListNode;

import java.util.stream.Stream;

import static com.leetcode.assertions.LinkedListAssertions.assertThatLinkedList;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MergeTwoSortedLists_21Test {

  MergeTwoSortedLists_21 solution = new MergeTwoSortedLists_21();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(LinkedList.of(1, 2, 4), LinkedList.of(1, 3, 4), LinkedList.of(1, 1, 2, 3, 4, 4)),
          arguments(LinkedList.of(1, 2, 4), LinkedList.empty(), LinkedList.of(1, 2, 4)),
          arguments(LinkedList.empty(), LinkedList.of(1, 2, 4), LinkedList.of(1, 2, 4)),
          arguments(LinkedList.empty(), LinkedList.empty(), LinkedList.empty()));
    }
  }


  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void mergeTwoLists(ListNode input1, ListNode input2, ListNode expected) {
    ListNode result = solution.mergeTwoLists(input1, input2);

    assertThatLinkedList(result).isEqualTo(expected);
  }
}
