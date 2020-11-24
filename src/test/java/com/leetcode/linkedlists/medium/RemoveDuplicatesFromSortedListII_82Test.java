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

class RemoveDuplicatesFromSortedListII_82Test {
  private final RemoveDuplicatesFromSortedListII_82 solution =
      new RemoveDuplicatesFromSortedListII_82();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(LinkedList.of(1, 2, 3, 3, 4, 4, 5), LinkedList.of(1, 2, 5)),
          arguments(LinkedList.of(1, 1, 1, 2, 3), LinkedList.of(2, 3)),
          arguments(LinkedList.of(1, 1, 1), LinkedList.empty()));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void deleteDuplicates(ListNode input, ListNode expectedResult) {
    ListNode actualResult = solution.deleteDuplicates(input);

    assertThatLinkedList(actualResult).isEqualTo(expectedResult);
  }
}
