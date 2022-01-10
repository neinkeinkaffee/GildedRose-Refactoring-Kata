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
                    item.sellIn -= 1;
                    if (item.sellIn < 0) {
                        item.increaseQuality();
                        item.increaseQuality();
                    } else {
                        item.increaseQuality();
                    }
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    item.sellIn -= 1;

                    if (item.sellIn >= 10) {
                        item.increaseQuality();
                    } else if (item.sellIn >= 5) {
                        item.increaseQuality();
                        item.increaseQuality();
                    } else if (item.sellIn >= 0) {
                        item.increaseQuality();
                        item.increaseQuality();
                        item.increaseQuality();
                    } else {
                        item.quality = 0;
                    }
                    break;

                default:
                    item.sellIn -= 1;

                    if (item.sellIn < 0) {
                        item.decreaseQuality();
                        item.decreaseQuality();
                    } else {
                        item.decreaseQuality();
                    }
                    break;
            }
        }
    }
}
