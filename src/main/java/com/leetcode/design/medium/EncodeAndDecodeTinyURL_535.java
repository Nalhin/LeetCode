package com.leetcode.design.medium;

// Note: This is a companion problem to the System Design problem: Design TinyURL
// .
//
// TinyURL is a URL shortening service where you enter a URL such as https://lee
// tcode.com/problems/design-tinyurl and it returns a short URL such as http://tiny
// url.com/4e9iAk.
//
// Design the encode and decode methods for the TinyURL service. There is no res
// triction on how your encode/decode algorithm should work. You just need to ensur
// e that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the
// original URL.
// Related Topics Hash Table Math
// 👍 853 👎 1738
/*
 O(n) Runtime: 7 ms, faster than 37.20% of Java online submissions for Encode and Decode TinyURL.
 O(n) Memory Usage: 39.2 MB, less than 62.18% of Java online submissions for Encode and Decode TinyURL.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL_535 {
  static class Codec {
    private int counter = 1;
    private final Map<Integer, String> map = new HashMap<>();
    private final String BASE = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
      map.put(counter, longUrl);
      return BASE + counter++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
      String[] split = shortUrl.split("/");
      return map.get(Integer.parseInt(split[split.length - 1]));
    }
  }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
// leetcode submit region end(Prohibit modification and deletion)
