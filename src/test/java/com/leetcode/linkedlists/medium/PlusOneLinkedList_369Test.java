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

class PlusOneLinkedList_369Test {

  private final PlusOneLinkedList_369 solution = new PlusOneLinkedList_369();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(LinkedList.of(1, 2, 3), LinkedList.of(1, 2, 4)),
          arguments(LinkedList.of(9, 9, 9), LinkedList.of(1, 0, 0, 0)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void plusOne(ListNode input, ListNode expectedResult) {
    ListNode actualResult = solution.plusOne(input);

    assertThatLinkedList(actualResult).isEqualTo(expectedResult);
  }
}
