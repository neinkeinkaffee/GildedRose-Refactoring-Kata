package com.gildedrose;

class BrieUpdater extends ItemUpdater {
    public void updateQuality(Item item) {
        super.incrementQuality(item);
        if (item.sellIn < 0) {
            super.incrementQuality(item);
        }
    }
}
