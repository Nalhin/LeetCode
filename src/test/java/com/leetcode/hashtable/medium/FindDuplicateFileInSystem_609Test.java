package com.leetcode.hashtable.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindDuplicateFileInSystem_609Test {

  private final FindDuplicateFileInSystem_609 solution = new FindDuplicateFileInSystem_609();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new String[] {
                "root/a 1.txt(abcd) 2.txt(efgh)",
                "root/c 3.txt(abcd)",
                "root/c/d 4.txt(efgh)",
                "root 4.txt(efgh)"
              },
              List.of(
                  List.of("root/a/2.txt", "root/c/d/4.txt", "root/4.txt"),
                  List.of("root/a/1.txt", "root/c/3.txt"))),
          arguments(
              new String[] {
                "root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)"
              },
              List.of(
                  List.of("root/a/2.txt", "root/c/d/4.txt"),
                  List.of("root/a/1.txt", "root/c/3.txt"))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findDuplicate(String[] paths, List<List<String>> expectedResult) {
    List<List<String>> actualResult = solution.findDuplicate(paths);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
