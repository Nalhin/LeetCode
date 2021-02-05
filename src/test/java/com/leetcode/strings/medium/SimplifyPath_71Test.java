package com.leetcode.strings.medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SimplifyPath_71Test {

  private final SimplifyPath_71 solution = new SimplifyPath_71();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("/home/", "/home"),
          arguments("/../", "/"),
          arguments("/home//foo", "/home/foo"),
          arguments("/a/./b/../../c/", "/c"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void getSmallestString(String path, String expectedResult) {
    String actualResult = solution.simplifyPath(path);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
