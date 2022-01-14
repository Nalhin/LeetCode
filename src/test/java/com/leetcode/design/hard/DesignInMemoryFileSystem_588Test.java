package com.leetcode.design.hard;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DesignInMemoryFileSystem_588Test {

  @Test
  void acceptanceTest() {
    DesignInMemoryFileSystem_588.FileSystem fileSystem =
        new DesignInMemoryFileSystem_588.FileSystem();

    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(fileSystem.ls("/")).isEmpty();
    fileSystem.mkdir("/a/b/c");
    fileSystem.addContentToFile("/a/b/c/d", "hello");
    softAssertions.assertThat(fileSystem.ls("/")).isEqualTo(List.of("a"));
    softAssertions.assertThat(fileSystem.readContentFromFile("/a/b/c/d")).isEqualTo("hello");
    softAssertions.assertAll();
  }
}
