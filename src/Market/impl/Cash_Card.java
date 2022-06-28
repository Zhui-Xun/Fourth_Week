package Market.impl;

import Market.Interface.Card;
import Market.Interface.Customer;
import Market.Interface.Shopping_Cart;

/**
 * 抵扣现金的卡
 */
// TODO: 思考题：怎么使用这个类才好呢？
public class Cash_Card implements Card {

    // 1:1抵扣现金的点数
    private double point;

    public Cash_Card(double point) {
        this.point = point;
    }

    @Override
    public double processCardDiscount(double totalCost, double totalCostAfterDiscount,
                                      Customer customer, Shopping_Cart shoppingCart) {
        // 如果折扣下来剩下的钱比点数少，那么就抵扣掉需要付的剩下的钱
        if (totalCostAfterDiscount < point) {
            point -= totalCostAfterDiscount;
            return totalCostAfterDiscount;
        } else {
            // 否则就抵扣掉所有的点
            point = 0;
            return point;
        }
    }
}


