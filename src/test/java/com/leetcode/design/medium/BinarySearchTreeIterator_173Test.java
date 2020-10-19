package com.leetcode.design.medium;

import com.leetcode.utils.BinaryTree;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class BinarySearchTreeIterator_173Test {
  @Test
  void acceptanceTest() {
    BinarySearchTreeIterator_173.BSTIterator iterator =
        new BinarySearchTreeIterator_173.BSTIterator(BinaryTree.of(7, 3, 15, null, null, 9, 20));
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(iterator.next()).isEqualTo(3);
    softAssertions.assertThat(iterator.next()).isEqualTo(7);
    softAssertions.assertThat(iterator.hasNext()).isTrue();
    softAssertions.assertThat(iterator.next()).isEqualTo(9);
    softAssertions.assertThat(iterator.hasNext()).isTrue();
    softAssertions.assertThat(iterator.next()).isEqualTo(15);
    softAssertions.assertThat(iterator.hasNext()).isTrue();
    softAssertions.assertThat(iterator.next()).isEqualTo(20);
    softAssertions.assertThat(iterator.hasNext()).isFalse();
    softAssertions.assertAll();
  }
}
