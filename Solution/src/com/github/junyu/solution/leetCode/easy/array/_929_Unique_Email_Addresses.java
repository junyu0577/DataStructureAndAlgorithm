package com.github.junyu.solution.leetCode.easy.array;

import java.util.HashSet;
import java.util.Set;

public class _929_Unique_Email_Addresses {

  /*  Every email consists of a local name and a domain name, separated by the @ sign.

    For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.

    Besides lowercase letters, these emails may contain '.'s or '+'s.

    If you add periods ('.') between some characters in the local name part of an email address, 
    mail sent there will be forwarded to the same address without dots in the local name.  
    For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address. 
        (Note that this rule does not apply for domain names.)

    If you add a plus ('+') in the local name, everything after the first plus sign will be ignored.
    This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.
        (Again, this rule does not apply for domain names.)

    It is possible to use both of these rules at the same time.

    Given a list of emails, we send one email to each address in the list.  How many 
    different addresses actually receive mails?



    Example 1:

    Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
    Output: 2
    Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails


    Note:

            1 <= emails[i].length <= 100
            1 <= emails.length <= 100
    Each emails[i] contains exactly one '@' character.*/

    /**
     * 统计邮箱的数量，@之前的.可以被忽略，以后的不能被忽略。如果有+符号，那么+符号，那么从+开始到@符号的前一位，都不计入地址中。
     * 首先判断遍历到的地址是否包含+，如果包含，那么从0到+号位置就是localname部分，这部分的.符号可以被忽略。
     * 如果不包含+符号，那么直接从0到@符号就是localname部分。
     * 然后再截取中右边的部分与左边的部分进行拼接，存入set集合中，最后set的数量唯一邮箱的数量。
     *
     * @param emails
     * @return
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet();
        for (int i = 0; i < emails.length; i++) {
            String email = emails[i];
            String leftPart;
            int mid = email.indexOf("@");
            if (email.contains("+")) {
                leftPart = email.substring(0, email.indexOf("+")).replaceAll("\\.", "");
            } else {
                leftPart = email.substring(0, mid).replaceAll("\\.", "");
            }
            email = leftPart + email.substring(mid);
            set.add(email);
        }
        return set.size();
    }

    public static void main(String[] args) {
        _929_Unique_Email_Addresses unique_email_addresses = new _929_Unique_Email_Addresses();
        System.out.println(unique_email_addresses.numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
    }

}
