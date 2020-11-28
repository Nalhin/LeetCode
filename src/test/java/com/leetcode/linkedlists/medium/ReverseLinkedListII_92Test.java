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

class ReverseLinkedListII_92Test {

  private final ReverseLinkedListII_92 solution = new ReverseLinkedListII_92();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(LinkedList.of(1, 2, 3, 4, 5), 2, 4, LinkedList.of(1, 4, 3, 2, 5)),
          arguments(LinkedList.of(5, 4, 3, 2, 1), 1, 5, LinkedList.of(1, 2, 3, 4, 5)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void reverseBetween(ListNode input, int m, int n, ListNode expectedResult) {

    ListNode actualResult = solution.reverseBetween(input, m, n);

    assertThatLinkedList(actualResult).isEqualTo(expectedResult);
  }
}
