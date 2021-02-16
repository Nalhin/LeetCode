package com.leetcode.tree.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KillProcess_582Test {
  private final KillProcess_582 solution = new KillProcess_582();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(List.of(1, 3, 10, 5), List.of(3, 0, 5, 3), 5, List.of(5, 10)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void killProcess(List<Integer> pid, List<Integer> ppid, int kill, List<Integer> expectedResult) {
    List<Integer> actualResult = solution.killProcess(pid, ppid, kill);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
