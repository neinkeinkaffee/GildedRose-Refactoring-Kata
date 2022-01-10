package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            int delta;
            switch (item.name) {
                case "Sulfuras, Hand of Ragnaros":
                    break;

                case "Aged Brie":
                    item.updateSellIn(-1);

                    delta = 1;
                    if (item.sellIn < 0) {
                        delta = 2;
                    }
                    item.updateQuality(delta);
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    item.updateSellIn(-1);

                    delta = -item.quality;
                    if (item.sellIn >= 10) {
                        delta = 1;
                    } else if (item.sellIn >= 5) {
                        delta = 2;
                    } else if (item.sellIn >= 0) {
                        delta = 3;
                    }
                    item.updateQuality(delta);
                    break;

                default:
                    item.updateSellIn(-1);

                    delta = -1;
                    if (item.sellIn < 0) {
                        delta = -2;
                    }
                    item.updateQuality(delta);
                    break;
            }
        }
    }
}
