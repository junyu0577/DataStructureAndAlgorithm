package com.github.junyu.solution.leetCode.medium.design;


import java.util.HashMap;
import java.util.Map;

public class _535_Encode_and_Decode_TinyURL {

   /* Note: This is a companion problem to the System Design problem: Design TinyURL.
    TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl
    // and it returns a short URL such as http://tinyurl.com/4e9iAk.

    Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode
    algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be
    decoded to the original URL.*/


    private Map<String, String> urls = new HashMap<>();
    private int ids = 0;

    /**
     * 短网址算法
     * 最无脑的解法就是使用map，key为原始网址，值为自增的id（从1开始），
     * 编码的时候就是将原网址和id存入map，并返回id。
     * 解码时通过迭代map比较value和id，相等就返回对应的key。
     *
     * @param longUrl
     * @return
     */
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        if (!urls.containsKey(longUrl)) {
            ids++;
            urls.put(longUrl, String.valueOf(ids));
        }
        return urls.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        for (Map.Entry<String, String> entry : urls.entrySet()) {
            if (entry.getValue().equals(shortUrl))
                return entry.getKey();
        }
        return null;
    }

    public static void main(String[] args) {
        _535_Encode_and_Decode_TinyURL encode_and_decode_tinyURL = new _535_Encode_and_Decode_TinyURL();
        System.out.println(encode_and_decode_tinyURL.decode(encode_and_decode_tinyURL.encode("https://leetcode.com/problems/design-tinyurl"))
        );
    }

}
