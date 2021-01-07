package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AddBinary_67Test {

  private final AddBinary_67 solution = new AddBinary_67();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("11", "1", "100"),
          arguments("1010", "1011", "10101"),
          arguments("1111", "1111", "11110"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void addBinary(String input1, String input2, String expectedResult) {
    String actualResult = solution.addBinary(input1, input2);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
