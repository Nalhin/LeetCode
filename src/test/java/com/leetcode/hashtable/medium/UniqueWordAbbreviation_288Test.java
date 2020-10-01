package com.leetcode.hashtable.medium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.leetcode.hashtable.medium.UniqueWordAbbreviation_288.ValidWordAbbr;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class UniqueWordAbbreviation_288Test {

    @Nested
    class ValidWordAbbrClass{
        @Test
        @DisplayName("Should work with an abbreviation that has a single corresponding word")
        void workWithSingleWordCorrespondingToAbbr(){
            ValidWordAbbr struct = new ValidWordAbbr(new String[]{"hello"});

            boolean actualResult = struct.isUnique("hello");

            assertThat(actualResult).isTrue();
        }

        @Test
        @DisplayName("Should work with a word that has different corresponding abbr")
        void worksWithWordThatHasDiffAbbr(){
            ValidWordAbbr struct = new ValidWordAbbr(new String[]{"cake"});

            boolean actualResult = struct.isUnique("cane");

            assertThat(actualResult).isFalse();
        }
    }
}
