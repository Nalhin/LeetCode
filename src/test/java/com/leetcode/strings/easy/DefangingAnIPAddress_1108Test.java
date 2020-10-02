package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DefangingAnIPAddress_1108Test {

  private final DefangingAnIPAddress_1108 solution = new DefangingAnIPAddress_1108();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("1.1.1.1", "1[.]1[.]1[.]1"),
          arguments("255.100.50.0", "255[.]100[.]50[.]0"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void defangIPaddr(String address, String expectedResult) {

    String actualResult = solution.defangIPaddr(address);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
