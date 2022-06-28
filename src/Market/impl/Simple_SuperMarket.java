package Market.impl;

import Market.Interface.Category;
import Market.Interface.Merchandise;
import Market.Interface.Super_Market;

import static Market.Shopping_Util.output;

public class Simple_SuperMarket implements Super_Market {

    private String name = "无名";

    private Merchandise[] all;
    private int[] allCount;

    private double totalMoneyEarn;

    private int customerCount;

    public Simple_SuperMarket(Merchandise[] all) {
        this.all = all;
        allCount = new int[all.length];
        for (int i = 0; i < all.length; i++) {
            allCount[i] = all[i].getCount();
        }
    }

    @Override
    public Merchandise[] getAllMerchandise() {
        return all;
    }

    @Override
    public Merchandise[] getRandomMerchandiseOfCategory(Category category) {
        Merchandise[] ret = new Merchandise[5];
        int pos = 0;
        for (Merchandise m : all) {
            if (m.getCategory() == category && Math.random() > 0.5 && pos < ret.length - 1) {
                ret[pos] = m;
                pos++;
            }
        }
        return ret;
    }

    @Override
    public void addEarnedMoney(double moneyEarn) {
        customerCount++;
        this.totalMoneyEarn += moneyEarn;
    }

    @Override
    public void dailyReport() {
        output("营业额为：" + totalMoneyEarn);
        output("商品售出情况如下：");
        for (int i = 0; i < all.length; i++) {
            if (allCount[i] != all[i].getCount()) {
                System.out.println(all[i].getCategory().name()
                        + "\t" + all[i].getName() + "\t" + (allCount[i] - all[i].getCount()));
            }
        }


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}





