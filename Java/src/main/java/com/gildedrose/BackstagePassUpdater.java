package com.gildedrose;

class BackstagePassUpdater extends ItemUpdater {
    public void updateQuality(Item item) {
        if (item.sellIn < 0) {
            setQualityToZeroAfterConcert(item);
        } else {
            increaseQualityBeforeConcert(item);
        }
    }

    private void setQualityToZeroAfterConcert(Item item) {
        item.quality = 0;
    }

    private void increaseQualityBeforeConcert(Item item) {
        if (item.sellIn < 5) {
            super.incrementQuality(item);
        }
        if (item.sellIn < 10) {
            super.incrementQuality(item);
        }
        super.incrementQuality(item);
    }
}
