package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            switch (items[i].name) {
                case "Sulfuras, Hand of Ragnaros":
                    break;

                case "Aged Brie":
                    items[i].sellIn -= 1;
                    if (items[i].sellIn < 0) {
                        items[i].increaseQuality();
                        items[i].increaseQuality();
                    } else {
                        items[i].increaseQuality();
                    }
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    items[i].sellIn -= 1;

                    items[i].increaseQuality();

                    if (items[i].sellIn < 10) {
                        items[i].increaseQuality();
                    }

                    if (items[i].sellIn < 5) {
                        items[i].increaseQuality();
                    }

                    if (items[i].sellIn < 0) {
                        items[i].quality = 0;
                    }
                    break;

                default:
                    items[i].sellIn -= 1;

                    if (items[i].sellIn < 0) {
                        items[i].decreaseQuality();
                        items[i].decreaseQuality();
                    } else {
                        items[i].decreaseQuality();
                    }
                    break;
            }
        }
    }
}
