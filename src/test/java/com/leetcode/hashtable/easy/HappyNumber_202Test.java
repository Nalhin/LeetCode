package com.leetcode.hashtable.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class HappyNumber_202Test {

  private final HappyNumber_202.HashTable hashTable = new HappyNumber_202.HashTable();
  private final HappyNumber_202.Floyd floyd = new HappyNumber_202.Floyd();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(19, true), arguments(1, true), arguments(20, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isHappyHashTable(int input, boolean expectedResult) {

    boolean actualResult = hashTable.isHappy(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isHappyFloyd(int input, boolean expectedResult) {

    boolean actualResult = floyd.isHappy(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
