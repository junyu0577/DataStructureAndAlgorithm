package com.github.junyu.solution.leetCode.medium.design;

public class _1357_Apply_Discount_Every_n_Orders {

    /*There is a sale in a supermarket, there will be a discount every n customer.
    There are some products in the supermarket where the id of the i-th product is products[i] and the price per unit
     of this product is prices[i].
    The system will count the number of customers and when the n-th customer arrive he/she will have a discount on
    the bill. (i.e if the cost is x the new cost is x - (discount * x) / 100). Then the system will start counting
    customers again.
    The customer orders a certain amount of each product where product[i] is the id of the i-th product the customer
    ordered and amount[i] is the number of units the customer ordered of that product.

    Implement the Cashier class:

    Cashier(int n, int discount, int[] products, int[] prices) Initializes the object with n, the discount,
    the products and their prices.
    double getBill(int[] product, int[] amount) returns the value of the bill and apply the discount if needed.
    Answers within 10^-5 of the actual value will be accepted as correct.

    Example 1:

        Input
    ["Cashier","getBill","getBill","getBill","getBill","getBill","getBill","getBill"]
            [[3,50,[1,2,3,4,5,6,7],[100,200,300,400,300,200,100]],[[1,2],[1,2]],[[3,7],[10,10]],
            [[1,2,3,4,5,6,7],[1,1,1,1,1,1,1]],[[4],[10]],[[7,3],[10,10]],[[7,5,3,1,6,4,2],[10,10,10,9,9,9,7]],[[2,3,
            5],[5,3,2]]]
        Output
    [null,500.0,4000.0,800.0,4000.0,4000.0,7350.0,2500.0]
        Explanation
        Cashier cashier = new Cashier(3,50,[1,2,3,4,5,6,7],[100,200,300,400,300,200,100]);
    cashier.getBill([1,2],[1,2]);                        // return 500.0, bill = 1 * 100 + 2 * 200 = 500.
    cashier.getBill([3,7],[10,10]);                      // return 4000.0
    cashier.getBill([1,2,3,4,5,6,7],[1,1,1,1,1,1,1]);    // return 800.0, The bill was 1600.0 but as this is the third
     customer, he has a discount of 50% which means his bill is only 1600 - 1600 * (50 / 100) = 800.
    cashier.getBill([4],[10]);                           // return 4000.0
    cashier.getBill([7,3],[10,10]);                      // return 4000.0
    cashier.getBill([7,5,3,1,6,4,2],[10,10,10,9,9,9,7]); // return 7350.0, Bill was 14700.0 but as the system
    counted three more customers, he will have a 50% discount and the bill becomes 7350.0
    cashier.getBill([2,3,5],[5,3,2]);                    // return 2500.0


    Constraints:

            1 <= n <= 10^4
            0 <= discount <= 100
            1 <= products.length <= 200
            1 <= products[i] <= 200
    There are not repeated elements in the array products.
            prices.length == products.length
    1 <= prices[i] <= 1000
            1 <= product.length <= products.length
    product[i] exists in products.
            amount.length == product.length
    1 <= amount[i] <= 1000
    At most 1000 calls will be made to getBill.
    Answers within 10^-5 of the actual value will be accepted as correct.*/

    /**
     * 每隔n个顾客打折
     * 思路：将商品的价格保存到哈希表，然后结账的时候先统计价格，如果刚好是第n个客户就计算折扣。
     */
    static class Cashier {

        private int n = 0;
        private int[] priceMap;
        private int index = 0;
        private double discount;


        public Cashier(int n, int discount, int[] products, int[] prices) {
            this.n = n;
            this.discount = discount * 0.01;
            priceMap = new int[201];
            for (int i = 0; i < products.length; i++) {
                priceMap[products[i]] = prices[i];
            }
        }

        public double getBill(int[] product, int[] amount) {
            index++;
            double sum = 0;
            for (int i = 0; i < product.length; i++) {
                sum += priceMap[product[i]] * amount[i];
            }

            if (index == n) {
                sum = sum - sum * discount;
                index = 0;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Cashier cashier = new Cashier(3, 50, new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{100, 200, 300, 400, 300, 200,
                100});
        System.out.println(cashier.getBill(new int[]{1, 2}, new int[]{1, 2}));
        // return 500.0, bill = 1 * 100 + 2 * 200 = 500.
        System.out.println(cashier.getBill(new int[]{3, 7}, new int[]{10, 10}));
        // return 4000.0
        System.out.println(cashier.getBill(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{1, 1, 1, 1, 1, 1, 1}));
        // return 800.0, The bill was 1600.0 but as this is the third
//        customer, he has a discount of 50% which means his bill is only 1600 - 1600 * (50 / 100) = 800.
        System.out.println(cashier.getBill(new int[]{4}, new int[]{10}));
        // return 4000.0
        System.out.println(cashier.getBill(new int[]{7, 3}, new int[]{10, 10}));
        // return 4000.0
        System.out.println(cashier.getBill(new int[]{7, 5, 3, 1, 6, 4, 2}, new int[]{10, 10, 10, 9, 9, 9, 7}));
        // return 7350.0, Bill was 14700.0 but as the system
//        counted three more customers, he will have a 50% discount and the bill becomes 7350.0
        System.out.println(cashier.getBill(new int[]{2, 3, 5}, new int[]{5, 3, 2}));
        // return 2500.0
    }
}
