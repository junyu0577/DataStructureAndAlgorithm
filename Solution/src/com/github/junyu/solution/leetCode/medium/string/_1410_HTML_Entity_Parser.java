package com.github.junyu.solution.leetCode.medium.string;

public class _1410_HTML_Entity_Parser {

   /* HTML entity parser is the parser that takes HTML code as input and replace all
    the entities of the special characters by the characters itself.

    The special characters and their entities for HTML are:

    Quotation Mark: the entity is &quot; and symbol character is ".
    Single Quote Mark: the entity is &apos; and symbol character is '.
    Ampersand: the entity is &amp; and symbol character is &.
    Greater Than Sign: the entity is &gt; and symbol character is >.
    Less Than Sign: the entity is &lt; and symbol character is <.
    Slash: the entity is &frasl; and symbol character is /.
    Given the input text string to the HTML parser, you have to implement the entity parser.

    Return the text after replacing the entities by the special characters.

    Example 1:

    Input: text = "&amp; is an HTML entity but &ambassador; is not."
    Output: "& is an HTML entity but &ambassador; is not."
    Explanation: The parser will replace the &amp; entity by &
    Example 2:

    Input: text = "and I quote: &quot;...&quot;"
    Output: "and I quote: \"...\""
    Example 3:

    Input: text = "Stay home! Practice on Leetcode :)"
    Output: "Stay home! Practice on Leetcode :)"
    Example 4:

    Input: text = "x &gt; y &amp;&amp; x &lt; y is always false"
    Output: "x > y && x < y is always false"
    Example 5:

    Input: text = "leetcode.com&frasl;problemset&frasl;all"
    Output: "leetcode.com/problemset/all"

    Constraints:

    1 <= text.length <= 10^5
    The string may contain any possible characters out of all the 256 ASCII characters.

    */

    /**
     * 替换html转义字符
     * 唯一要注意的点是替换后的字符（&）与剩余的字符组成了新的转义字符不能再替换，因此
     * 将(&amp;)放在最后进行批量替换。
     * @param text
     * @return
     */
    public String entityParser(String text) {
        text = text.replaceAll("&quot;","\"");
        text = text.replaceAll("&apos;","'");
        text = text.replaceAll("&gt;",">");
        text = text.replaceAll("&lt;","<");
        text = text.replaceAll("&frasl;","/");
        text = text.replaceAll("&amp;","&");
        return  text;
    }

    public static void main(String[] args) {
            _1410_HTML_Entity_Parser test = new _1410_HTML_Entity_Parser();
            System.out.println(test.entityParser("&amp; is an HTML entity but &ambassador; is not."));
            System.out.println(test.entityParser("and I quote: &quot;...&quot;"));
            System.out.println(test.entityParser("Stay home! Practice on Leetcode :)"));
            System.out.println(test.entityParser("x &gt; y &amp;&amp; x &lt; y is always false"));
            System.out.println(test.entityParser("leetcode.com&frasl;problemset&frasl;all"));
            System.out.println(test.entityParser("&amp;gt;"));
    }

}
