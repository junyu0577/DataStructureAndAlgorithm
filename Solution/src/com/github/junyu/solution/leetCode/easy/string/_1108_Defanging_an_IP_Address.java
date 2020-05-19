package com.github.junyu.solution.leetCode.easy.string;

public class _1108_Defanging_an_IP_Address {

  /*  Given a valid (IPv4) IP address, return a defanged version of that IP address.

    A defanged IP address replaces every period "." with "[.]".

    Example 1:

    Input: address = "1.1.1.1"
    Output: "1[.]1[.]1[.]1"
    Example 2:

    Input: address = "255.100.50.0"
    Output: "255[.]100[.]50[.]0"


    Constraints:

    The given address is a valid IPv4 address.*/

    /**
     * 替换ip地址中的"."为"[.]"
     * @param address
     * @return
     */
    public String defangIPaddr(String address) {
        StringBuilder ans = new StringBuilder();
        String[] arr = address.split("\\.");
        for (int i=0;i<arr.length-1;i++)
            ans.append(arr[i] + "[.]");
        ans.append(arr[3]);
        return ans.toString();
    }

    public static void main(String[] args) {
        _1108_Defanging_an_IP_Address test = new _1108_Defanging_an_IP_Address();
        System.out.println(test.defangIPaddr("1.1.1.1"));
        System.out.println(test.defangIPaddr("255.100.50.0"));
    }

}
