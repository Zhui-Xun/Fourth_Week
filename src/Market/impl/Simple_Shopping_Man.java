package Market.impl;

import Market.Interface.Shopping_Man;
import Market.Interface.*;

import static Market.Shopping_Util.output;


public class Simple_Shopping_Man implements Shopping_Man {

    private Super_Market superMarket;

    public Simple_Shopping_Man(Super_Market superMarket) {
        this.superMarket = superMarket;
    }

    private static final int MAX_BUY_DEFAULT = 9;

    @Override
    public void serveCustomer(Customer customer) {
        int maxTypeToBuy = MAX_BUY_DEFAULT;
        if (customer instanceof Abs_Customer) {
            maxTypeToBuy = ((Abs_Customer) customer).getGuangCount();
        }
        Shopping_Cart shoppingCart = new Shopping_Cart(maxTypeToBuy);
        customer.startShopping();

        while ((!customer.wantToCheckout()) && shoppingCart.canHold()) {
            Category category = customer.chooseCategory();
            // 简单的导购员，顾客说不想买就算了，不做推荐
            if (category == null) {
                continue;
            }
            Merchandise[] toChoose = superMarket.getRandomMerchandiseOfCategory(category);
            // 简单的导购员，一个个推荐，不说从价格高到低推荐之类的小技巧。
            for (Merchandise m : toChoose) {
                if (m == null) {
                    continue;
                }
                int buyCount = customer.buyMerchandise(m);
                if (buyCount > 0) {
                    // 一个类别只买一个商品
                    shoppingCart.add(m, buyCount);
                    break;
                }
            }
        }

        double originCost = shoppingCart.calculateOriginCost();
        double finalCost = originCost;

        double savedMoney = 0;
        if (customer instanceof Has_Card) {
            Card card = ((Has_Card) customer).getCard();
            savedMoney = card.processCardDiscount(originCost, finalCost, customer, shoppingCart);
            finalCost -= savedMoney;
        }

        double moneyEarned = customer.payFor(shoppingCart, finalCost);

        superMarket.addEarnedMoney(moneyEarned);

        output("顾客 <" + customer.getCustId() + "> 购物清单如下：");
        output(shoppingCart.toString());
        output("优惠金额为：" + savedMoney);
        output("实付金额为：" + moneyEarned);
    }

}
