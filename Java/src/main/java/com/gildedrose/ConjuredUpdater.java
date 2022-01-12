package com.gildedrose;

class ConjuredUpdater extends ItemUpdater {
    public void updateQuality(Item item) {
        super.decrementQuality(item);
        super.decrementQuality(item);
        if (item.sellIn < 0) {
            super.decrementQuality(item);
            super.decrementQuality(item);
        }
    }
}
