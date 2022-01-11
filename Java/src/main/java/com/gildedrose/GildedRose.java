package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateSellIn(item);
            updateQuality(item);
        }
    }

    private void updateSellIn(Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                return;
        }
        item.sellIn -= 1;
    }

    private void updateQuality(Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                if (item.sellIn < 0) {
                    item.quality = 0;
                } else {
                    if (item.sellIn < 5) {
                        incrementQuality(item);
                    }
                    if (item.sellIn < 10) {
                        incrementQuality(item);
                    }
                    incrementQuality(item);
                }
                break;
            case "Aged Brie":
                incrementQuality(item);
                if (item.sellIn < 0) {
                    incrementQuality(item);
                }
                break;
            case "Conjured Mana Cake":
                decrementQuality(item);
                decrementQuality(item);
                if (item.sellIn < 0) {
                    decrementQuality(item);
                    decrementQuality(item);
                }
                break;
            default:
                decrementQuality(item);
                if (item.sellIn < 0) {
                    decrementQuality(item);
                }
                break;
        }
    }

    private void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

    private void decrementQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }
}
