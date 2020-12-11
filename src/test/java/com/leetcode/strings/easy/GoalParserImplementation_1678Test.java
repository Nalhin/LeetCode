package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GoalParserImplementation_1678Test {

  private final GoalParserImplementation_1678 solution = new GoalParserImplementation_1678();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("G()(al)", "Goal"),
          arguments("G()()()()(al)", "Gooooal"),
          arguments("(al)G(al)()()G", "alGalooG"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void interpret(String command, String expectedResult) {
    String actualResult = solution.interpret(command);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
