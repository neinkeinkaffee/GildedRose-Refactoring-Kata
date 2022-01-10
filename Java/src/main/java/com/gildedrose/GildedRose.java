package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            int updateDelta;
            switch (item.name) {
                case "Sulfuras, Hand of Ragnaros":
                    updateDelta = 0;
                    break;

                case "Aged Brie":
                    item.updateSellIn(-1);

                    updateDelta = 1;
                    if (item.sellIn < 0) {
                        updateDelta = 2;
                    }
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    item.updateSellIn(-1);

                    updateDelta = -item.quality;
                    if (item.sellIn >= 10) {
                        updateDelta = 1;
                    } else if (item.sellIn >= 5) {
                        updateDelta = 2;
                    } else if (item.sellIn >= 0) {
                        updateDelta = 3;
                    }
                    break;

                default:
                    item.updateSellIn(-1);

                    updateDelta = -1;
                    if (item.sellIn < 0) {
                        updateDelta = -2;
                    }
                    break;
            }
            item.updateQuality(updateDelta);
        }
    }
}
