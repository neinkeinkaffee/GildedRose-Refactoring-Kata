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
                    items[i].increaseQuality();

                    items[i].sellIn = items[i].sellIn - 1;

                    if (items[i].sellIn < 0) {
                        items[i].increaseQuality();
                    }
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    if (items[i].quality < 50) {
                        items[i].increaseQuality();

                        if (items[i].sellIn < 11) {
                            items[i].increaseQuality();
                        }

                        if (items[i].sellIn < 6) {
                            items[i].increaseQuality();
                        }
                    }

                    items[i].sellIn = items[i].sellIn - 1;

                    if (items[i].sellIn < 0) {
                        items[i].decreaseQuality();
                    }
                    break;

                default:
                    if (items[i].quality > 0) {
                        items[i].quality = items[i].quality - 1;
                    }

                    items[i].sellIn = items[i].sellIn - 1;

                    if (items[i].sellIn < 0) {
                        if (items[i].quality > 0) {
                            items[i].quality = items[i].quality - 1;
                        }
                    }
                    break;
            }
        }
    }
}
