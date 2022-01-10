package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Sulfuras, Hand of Ragnaros":
                    break;

                case "Aged Brie":
                    item.updateSellIn(-1);

                    if (item.sellIn >= 0) {
                        item.updateQuality(1);
                    } else {
                        item.updateQuality(2);
                    }
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    item.updateSellIn(-1);

                    if (item.sellIn >= 10) {
                        item.updateQuality(1);
                    } else if (item.sellIn >= 5) {
                        item.updateQuality(2);
                    } else if (item.sellIn >= 0) {
                        item.updateQuality(3);
                    } else {
                        item.quality = 0;
                    }
                    break;

                default:
                    item.updateSellIn(-1);

                    if (item.sellIn >= 0) {
                        item.updateQuality(-1);
                    } else {
                        item.updateQuality(-2);
                    }
                    break;
            }
        }
    }
}
