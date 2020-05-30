package com.github.junyu.solution.leetCode.easy.string;


public class _1189_Maximum_Number_of_Balloons {

    /*Given a string text, you want to use the characters of text to form
    as many instances of the word "balloon" as possible.

    You can use each character in text at most once. Return the maximum number
    of instances that can be formed.

    Example 1:

    Input: text = "nlaebolko"
    Output: 1
    Example 2:

    Input: text = "loonbalxballpoon"
    Output: 2
    Example 3:

    Input: text = "leetcode"
    Output: 0

    Constraints:

            1 <= text.length <= 10^4
    text consists of lower case English letters only.*/

    /**
     * 统计字符串可能组成几个'balloon'
     * 思路：先统计每个字符出现的次数，然后分别读取a、b、l、o、n的数量，记录这五个字符
     * 中出现次数最小的值，由于l和o都需要double才能组成一个单词，因此统计的时候需要对他们
     * 的数量进行除2，最后最小的值即能够组成的单词数量。
     *
     * @param text
     * @return
     */
    public int maxNumberOfBalloons(String text) {
        int len = text.length();

        int [] count = new int[26];
        for (int i=0;i<len;i++){
            count[text.charAt(i)-'a']++;
        }

        int min = count[0];//a
        min = Math.min(min,count[1]);//b
        min = Math.min(min,count[11]/2);//l
        min = Math.min(min,count[14]/2);//o
        min = Math.min(min,count[13]);//n

        return min;
    }

    public static void main(String[] args) {
        _1189_Maximum_Number_of_Balloons test = new _1189_Maximum_Number_of_Balloons();
        System.out.println(test.maxNumberOfBalloons("nlaebolko"));
        System.out.println(test.maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(test.maxNumberOfBalloons("leetcode"));
        System.out.println(test.maxNumberOfBalloons("krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw"));



    }
}
