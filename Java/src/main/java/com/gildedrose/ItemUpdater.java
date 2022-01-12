package com.gildedrose;

class ItemUpdater {
    void update(Item item) {
        updateSellIn(item);
        updateQuality(item);
    }

    public void updateSellIn(Item item) {
        decrementSellIn(item);
    }

    public void updateQuality(Item item) {
        decrementQuality(item);
        if (item.sellIn < 0) {
            decrementQuality(item);
        }
    }

    private void decrementSellIn(Item item) {
        item.sellIn -= 1;
    }

    public void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

    public void decrementQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }
}
