package com.github.junyu.solution.leetCode.medium.design;

import java.util.ArrayList;
import java.util.List;

public class _1472_Design_Browser_History {

    /*You have a browser of one tab where you start on the homepage and you can
    visit another url, get back in the history number of steps or move forward
    in the history number of steps.

    Implement the BrowserHistory class:

    BrowserHistory(string homepage) Initializes the object with the homepage
    of the browser.
    void visit(string url) visits url from the current page. It clears up all
     the forward history.
            string back(int steps) Move steps back in history. If you can only
            return x steps in the history and steps > x, you will return only
             x steps. Return the current url after moving back in history at most steps.
    string forward(int steps) Move steps forward in history. If you can only
    forward x steps in the history and steps > x, you will forward only x steps.
     Return the current url after forwarding in history at most steps.

    Example:

    Input:
            ["BrowserHistory","visit","visit","visit","back","back","forward",
            "visit","forward","back","back"]
            [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],
            [1],[1],[1],["linkedin.com"],[2],[2],[7]]
    Output:
            [null,null,null,null,"facebook.com","google.com","facebook.com",null,
            "linkedin.com","google.com","leetcode.com"]

    Explanation:
    BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
    browserHistory.visit("google.com");
     // You are in "leetcode.com". Visit "google.com"
    browserHistory.visit("facebook.com");
     // You are in "google.com". Visit "facebook.com"
    browserHistory.visit("youtube.com");
     // You are in "facebook.com". Visit "youtube.com"
    browserHistory.back(1);
     // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
    browserHistory.back(1);
     // You are in "facebook.com", move back to "google.com" return "google.com"
    browserHistory.forward(1);
     // You are in "google.com", move forward to "facebook.com" return "facebook.com"
    browserHistory.visit("linkedin.com");
      // You are in "facebook.com". Visit "linkedin.com"
    browserHistory.forward(2);
      // You are in "linkedin.com", you cannot move forward any steps.
    browserHistory.back(2);
     // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
    browserHistory.back(7);
       // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"


    Constraints:

            1 <= homepage.length <= 20
            1 <= url.length <= 20
            1 <= steps <= 100
    homepage and url consist of  '.' or lower case English letters.
    At most 5000 calls will be made to visit, back, and forward.*/

    /**
     * 设计浏览器历史记录
     * 你有一个只支持单个标签页的 浏览器 ，最开始你浏览的网页是 homepage
     * ，你可以访问其他的网站 url ，也可以在浏览历史中后退 steps 步或前进 steps 步。
     * 请你实现 BrowserHistory 类：
     * BrowserHistory(string homepage) ，用 homepage 初始化浏览器类。
     * void visit(string url) 从当前页跳转访问 url 对应的页面  。执行此操作会把浏览历史前进的
     * 记录全部删除。
     * string back(int steps) 在浏览历史中后退 steps 步。如果你只能在浏览历史中后退至多
     * x 步且 steps > x ，那么你只后退 x 步。请返回后退 至多 steps 步以后的 url 。
     * string forward(int steps) 在浏览历史中前进 steps 步。如果你只能在浏览历史中前进至多
     * x 步且 steps > x ，那么你只前进 x 步。请返回前进 至多 steps步以后的 url 。
     * <p>
     * 思路：使用arrayList配合cursor，cursor指向当前正在访问的url，当visit一个新的页面时，
     * 如果cursor指向的不是最后一个元素，那么就把删除从cursor+1到最后的所有元素。
     * back的时候只更新cursor，如果当前位置-步数小于0，那么最多就只能退到0。
     * forward的时候同理，如果cursor+步数超出最后一个元素的角标，那就只能前进到最后一个元素。
     */
    static class BrowserHistory {

        private List<String> urls;
        private int cursor = 0;

        public BrowserHistory(String homepage) {
            urls = new ArrayList<>();
            urls.add(homepage);
        }

        public void visit(String url) {
            while (cursor < urls.size() - 1) {
                urls.remove(urls.size() - 1);
            }
            urls.add(url);
            cursor++;

        }

        public String back(int steps) {
            cursor = Math.max(cursor - steps, 0);
            return urls.get(cursor);
        }

        public String forward(int steps) {
            cursor = Math.min(cursor + steps, urls.size() - 1);
            return urls.get(cursor);
        }
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");
        // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");
        // You are in "facebook.com". Visit "youtube.com"
        System.out.println(browserHistory.back(1));
        // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        System.out.println(browserHistory.back(1));
        // You are in "facebook.com", move back to "google.com" return "google.com"
        System.out.println(browserHistory.forward(1));
        // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");
        // You are in "facebook.com". Visit "linkedin.com"
        System.out.println(browserHistory.forward(2));
        // You are in "linkedin.com", you cannot move forward any steps.
        System.out.println(browserHistory.back(2));
        // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        System.out.println(browserHistory.back(7));
        // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"

    }
}
