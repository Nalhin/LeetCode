package com.leetcode.queue.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class OpenTheLock_752Test {

  private final OpenTheLock_752 solution = new OpenTheLock_752();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new String[] {"0201", "0101", "0102", "1212", "2002"}, "0202", 6),
          arguments(new String[] {"8888"}, "0009", 1),
          arguments(
              new String[] {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"},
              "8888",
              -1),
          arguments(new String[] {"0000"}, "8888", -1),
          arguments(new String[] {"0201", "0101", "0102", "1212", "2002", "0000"}, "0000", 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void openLock(String[] deadends, String target, int expectedResult) {
    int actualResult = solution.openLock(deadends, target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
