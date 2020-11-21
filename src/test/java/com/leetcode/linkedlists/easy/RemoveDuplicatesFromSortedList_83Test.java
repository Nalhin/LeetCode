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

class RemoveDuplicatesFromSortedList_83Test {

  private final RemoveDuplicatesFromSortedList_83 solution =
      new RemoveDuplicatesFromSortedList_83();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(LinkedList.of(1, 1, 2), LinkedList.of(1, 2)),
          arguments(LinkedList.of(1, 1, 2, 3, 3), LinkedList.of(1, 2, 3)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isPalindrome(ListNode list, ListNode expectedResult) {
    ListNode actualResult = solution.deleteDuplicates(list);

    assertThatLinkedList(actualResult).isEqualTo(expectedResult);
  }
}
