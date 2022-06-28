package Market.impl;

import Market.Interface.Category;
import Market.Interface.Customer;
import Market.Interface.Shopping_Cart;

import static Market.Shopping_Util.getRandomCategory;


public abstract class Abs_Customer implements Customer {

    private Category shouldBuy;
    private String custId;
    private double moneySpent;
    private int guangLeft = 0;
    private int guangCount = 0;

    public static final int DEFAULT_GUANG_COUNT = 5;

    public Abs_Customer(String custId, Category shouldBuy, int guangCount) {
        this.shouldBuy = shouldBuy;
        this.guangCount = guangCount;
        this.custId = custId;
    }

    public int getGuangCount() {
        return guangCount;
    }

    public void setGuangCount(int guangCount) {
        this.guangCount = guangCount;
    }

    public Abs_Customer(String custId, Category shouldBuy) {
        this(custId, shouldBuy, DEFAULT_GUANG_COUNT);
    }

    @Override
    public String getCustId() {
        return custId;
    }

    @Override
    public void startShopping() {
        guangLeft = guangCount;
    }

    @Override
    public boolean wantToCheckout() {
        guangLeft--;
        return guangLeft <= 0;
    }

    @Override
    public double payFor(Shopping_Cart shoppingCart, double totalCost) {

        moneySpent += totalCost;
        return totalCost;
    }

    public Category getShouldBuy() {
        return shouldBuy;
    }

    /**
     * 先看必须买的，没有必须买的就随便看看
     *
     * @return 想要购买的商品种类
     */
    @Override
    public Category chooseCategory() {
        // 有一次机会看需要买的东西
        if (guangLeft + 1 >= guangCount) {
            return shouldBuy;
        } else {
            return getRandomCategory();
        }
    }

    @Override
    public double getMoneySpent() {
        return moneySpent;
    }

}