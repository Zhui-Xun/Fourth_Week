package Market.impl;

import Market.Interface.Card;
import Market.Interface.Customer;
import Market.Interface.Shopping_Cart;

public enum VIPCard implements Card {

    Level0(1),
    Level1(0.99),
    Level2(0.95),
    Level3(0.9),
    Level4(0.85),
    Level5(0.8);

    private double discount;

    VIPCard(double discount) {
        this.discount = discount;
    }

    @Override
    public double processCardDiscount(double totalCost, double totalCostAfterDiscount,
                                      Customer customer, Shopping_Cart shoppingCart) {
        return totalCostAfterDiscount * (1 - discount);
    }

}
