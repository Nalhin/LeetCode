package com.leetcode.hashtable.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SubdomainVisitCount_811Test {

  private final SubdomainVisitCount_811 solution = new SubdomainVisitCount_811();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new String[] {"9001 discuss.leetcode.com"},
              List.of("9001 com", "9001 leetcode.com", "9001 discuss.leetcode.com")),
          arguments(
              new String[] {
                "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"
              },
              List.of(
                  "901 mail.com",
                  "50 yahoo.com",
                  "900 google.mail.com",
                  "5 wiki.org",
                  "5 org",
                  "1 intel.mail.com",
                  "951 com")));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void subdomainVisits(String[] subdomains, List<String> expectedResult) {
    List<String> actualResult = solution.subdomainVisits(subdomains);

    assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
  }
}
