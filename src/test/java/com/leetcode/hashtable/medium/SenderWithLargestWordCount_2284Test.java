package com.leetcode.hashtable.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SenderWithLargestWordCount_2284Test {

  private final SenderWithLargestWordCount_2284 solution = new SenderWithLargestWordCount_2284();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new String[] {
                "Hello userTwooo", "Hi userThree", "Wonderful day Alice", "Nice day userThree"
              },
              new String[] {"Alice", "userTwo", "userThree", "Alice"},
              "Alice"),
          arguments(
              new String[] {"How is leetcode for everyone", "Leetcode is useful for practice"},
              new String[] {"Bob", "Charlie"},
              "Charlie"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void largestWordCount(String[] messages, String[] senders, String expectedResult) {
    String actualResult = solution.largestWordCount(messages, senders);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
