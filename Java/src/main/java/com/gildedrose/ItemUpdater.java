package com.gildedrose;

public class ItemUpdater {
    private Item item;

    public ItemUpdater(Item item) {
        this.item = item;
    }


    public void decrementSellIn() {
        item.sellIn -= 1;
    }

    public void incrementQuality() {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

    public void decrementQuality() {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }

    public boolean sellDateHasPassed() {
        return sellInLessThan(0);
    }

    public void setQualityToZero() {
        item.quality = 0;
    }

    public boolean sellInLessThan(int days) {
        return item.sellIn < days;
    }
}
