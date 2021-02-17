package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfMatchingSubsequences_792Test {

  private final NumberOfMatchingSubsequences_792 solution = new NumberOfMatchingSubsequences_792();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("abcde", new String[] {"a", "bb", "acd", "ace"}, 3),
          arguments(
              "ziyyxhtfbmgvnmvsqusddpvmrfskzaexergyqpjjusjfbzakugrjkglikryksufbftcjsmlzjmuwqdvlndetuzsyacmzdyulnrmv",
              new String[] {
                "n",
                "kugrjkglikryksufbftcjsmlzjmuwqdvlndetuzsyacmzdyul",
                "muwqdvlndetuzsyacmzdyuln",
                "vmrfskzaexergyqpjjusjfbzakugrjk",
                "skzaexergyqpjjusjfbzakugrjkglikryksufbftcjsmlz",
                "pywquphugcnfuvrduhrcoxxratptwmqmxwttykvkoskejgjhdy",
                "rutbpwjugodzrgwzkvjzaafusqnsoiyvgszstwtlabgoeygfrx",
                "ruhodvpdipmlacbuiuwmhpuvooraxrunwwlzctzsgacjupowdb",
                "effkefvkcztipbojcttajvlexwuazmzqtfwubehuawmivyhzpw",
                "geguatbhflhixqeikcnaxyugmepetztyblyrwfwnhzxofjonqs"
              },
              5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numMatchingSubseq(String input, String[] words, int expectedResult) {
    int actualResult = solution.numMatchingSubseq(input, words);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
