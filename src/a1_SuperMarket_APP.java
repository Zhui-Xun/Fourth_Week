
import Market.impl.Simple_Shopping_Man;

import static Market.Shopping_Util.*;

import Market.Interface.*;

public class a1_SuperMarket_APP {

    public static void main(String[] args) {
        // 创建超市
        Super_Market superMarket = createSuperMarket();
        //
        //System.out.println();

        Shopping_Man shopman = new Simple_Shopping_Man(superMarket);

        boolean open = true;
        while (open) {
            new ShoppingTask(shopman).executeTask();
            output("是否继续营业？(yes or no)");
            open = !input().next().trim().equalsIgnoreCase("no");
        }

        superMarket.dailyReport();
    }

}

class ShoppingTask {

    private Shopping_Man shopman;

    public ShoppingTask(Shopping_Man shopman) {
        this.shopman = shopman;
    }

    public void executeTask() {
        Customer customer = createCustomer(true);
        shopman.serveCustomer(customer);
    }

}

