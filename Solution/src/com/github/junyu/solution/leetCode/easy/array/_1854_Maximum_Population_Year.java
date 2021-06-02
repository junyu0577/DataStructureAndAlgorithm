package com.github.junyu.solution.leetCode.easy.array;


public class _1854_Maximum_Population_Year {


    /*You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years
     of the ith person.

    The population of some year x is the number of people alive during that year. The ith person is counted in year
    x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the
    year that they die.

    Return the earliest year with the maximum population.



    Example 1:

    Input: logs = [[1993,1999],[2000,2010]]
    Output: 1993
    Explanation: The maximum population is 1, and 1993 is the earliest year with this population.
            Example 2:

    Input: logs = [[1950,1961],[1960,1971],[1970,1981]]
    Output: 1960
    Explanation:
    The maximum population is 2, and it had happened in years 1960 and 1970.
    The earlier year between them is 1960.


    Constraints:

            1 <= logs.length <= 100
            1950 <= birthi < deathi <= 2050
    */

    /**
     * 人口最多的年份,返回人口最多且最早的年份。
     *
     * 从第二行开始累加各个年份的人口，符合（当前的年份[i][0] < 对比年份[j][1] &&  当前的年份[i][0] >= 对比年份[j][0]）
     * 则对比年份的人口+1.
     * 最后从ans找出人口最多的年份。当人口相同时，则优先替换为年份更小的值。
     *
     *
     * Runtime: 2 ms, faster than 50.31% of Java online submissions for Maximum Population Year.
     * Memory Usage: 36.8 MB, less than 84.43% of Java online submissions for Maximum Population Year.
     *
     * @param logs
     * @return
     */
    public int maximumPopulation(int[][] logs) {
        int[] ans = new int[logs.length];

        for (int i = 1; i < logs.length; i++) {
            for (int j = 0; j < logs.length; j++) {
                if (j == i)
                    continue;

                if (logs[i][0] < logs[j][1] && logs[i][0] >= logs[j][0]) {
                    ans[i]++;
                }
            }
        }

        int maxIndex = 0;
        int maxCount = ans[0];
        for (int i = 1; i < ans.length; i++) {
            if (maxCount < ans[i]) {
                maxCount = ans[i];
                maxIndex = i;
            } else if (maxCount == ans[i] && logs[i][0] < logs[maxIndex][0]) {
                maxIndex = i;
            }

        }


        return logs[maxIndex][0];
    }

    public static void main(String[] args) {
        _1854_Maximum_Population_Year test = new _1854_Maximum_Population_Year();
        System.out.println(test.maximumPopulation(new int[][]{{1993, 1999}, {2000, 2010}}));
        System.out.println(test.maximumPopulation(new int[][]{{1950, 1961}, {1960, 1971}, {1970, 1981}}));
        System.out.println(test.maximumPopulation(new int[][]{{2033, 2034}, {2039, 2047}, {1998, 2042}, {2047, 2048},
                {2025, 2029}, {2005, 2044}, {1990, 1992}, {1952, 1956}, {1984, 2014}}));

        System.out.println(test.maximumPopulation(new int[][]{{2038, 2040},{1988, 2030},{1952, 1974},{1956, 1978},{2040, 2047},
                {1994, 2011},{1976, 2044},{2038, 2043},{2012, 2023},{2049, 2050},{2034, 2049},{2015, 2022},{1988, 1998},{2037, 2046}
                ,{2039, 2048},{2045, 2050},{2034, 2046},{2014, 2025},{2009, 2026},{1976, 2007},{2021, 2045},{1995, 2000},{2009, 2042}
                ,{2027, 2037},{2004, 2009},{1955, 1990},{2001, 2042},{2009, 2042},{1992, 2010},{1958, 1968}}));



    }
}
