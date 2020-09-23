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

class ReverseLinkedList_206Test {

  private final ReverseLinkedList_206 solution = new ReverseLinkedList_206();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(LinkedList.of(1, 2, 3, 4, 5), LinkedList.of(5, 4, 3, 2, 1)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void reverseList(ListNode input, ListNode expectedResult) {
    ListNode actualResult = solution.reverseList(input);

    assertThatLinkedList(actualResult).isEqualTo(expectedResult);
  }
}
