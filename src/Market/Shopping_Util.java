package Market;


import Market.impl.*;
import Market.Interface.Category;
import Market.Interface.Customer;
import Market.Interface.Merchandise;
import Market.Interface.Super_Market;

import static Market.Shopping_Util.getRandomCategory;

import java.util.Scanner;

public class Shopping_Util {

    private static final Scanner in = new Scanner(System.in);

    public static Scanner input() {
        return in;
    }

    public static void output(Object obj) {
        System.out.println(String.valueOf(obj));
    }


    public static Super_Market createSuperMarket() {
        int merchandisePerCategory = 10;
        Merchandise[] all = new Merchandise[Category.values().length * merchandisePerCategory];

        for (Category category : Category.values()) {
            for (int i = 0; i < merchandisePerCategory; i++) {

                double soldPrice = Math.random() * (category.getHigherPrice() - category.getLowerPrice())
                        + category.getLowerPrice();

                double purchasePrice = soldPrice * 0.7;

                all[category.ordinal() * merchandisePerCategory + i] = new Simple_Merchandise(
                        category.name() + i, soldPrice, purchasePrice, 200, category
                );
            }
        }

        Simple_SuperMarket superMarket = new Simple_SuperMarket(all);
        // output("请输入超市的名字：");
        // String s = input().next();
        String s = "星光超市";
        if (s.trim().length() > 0) {
            superMarket.setName(s.trim());
        }
        System.out.println("\n\"" + s + "\"营业中...\n");
        return superMarket;
    }

    public static Customer createCustomer(boolean auto) {
        if (auto) {
            String custId = "Customer-" + (int) (Math.random() * 1000);
            Category shouldBuy = getRandomCategory();
            if (Math.random() < 0.5) {
                return new Random_Customer(custId, shouldBuy);
            } else {
                Think_and_Buy_Customer ret = new Think_and_Buy_Customer(custId, shouldBuy);
                ret.setCard(getRandomVIPCard());
                return ret;
            }
        }
        return null;

    }

    public static Category getRandomCategory() {
        return Category.values()[(int) (Math.random() * 1000) % Category.values().length];
    }

    public static VIPCard getRandomVIPCard() {
        return VIPCard.values()[(int) (Math.random() * 1000) % VIPCard.values().length];
    }


}




