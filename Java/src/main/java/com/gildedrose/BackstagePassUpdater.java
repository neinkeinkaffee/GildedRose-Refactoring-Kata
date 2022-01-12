package com.gildedrose;

class BackstagePassUpdater extends ItemUpdater {
    public void updateQuality(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        } else {
            if (item.sellIn < 5) {
                super.incrementQuality(item);
            }
            if (item.sellIn < 10) {
                super.incrementQuality(item);
            }
            super.incrementQuality(item);
        }
    }
}
