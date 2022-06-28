package Market.impl;

import Market.Interface.Card;
import Market.Interface.Category;
import Market.Interface.Has_Card;
import Market.Interface.Merchandise;

public class Think_and_Buy_Customer extends Abs_Customer implements Has_Card {

    private Card card = VIPCard.Level0;

    public Think_and_Buy_Customer(String custId, Category shouldBuy) {
        super(custId, shouldBuy, DEFAULT_GUANG_COUNT);
    }

    @Override
    public int buyMerchandise(Merchandise merchandise) {

        Category category = merchandise.getCategory();
        // 需要买的就买一个
        if (category == getShouldBuy()) {
            return 1;
        }

        double soldPrice = merchandise.getSoldPrice();

        double avgPrice = (category.getHigherPrice() + category.getLowerPrice()) / 2;
        if (soldPrice < avgPrice) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public Card getCard() {
        return card;
    }

}



