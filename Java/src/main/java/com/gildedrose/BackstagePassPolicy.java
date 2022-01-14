package com.gildedrose;

class BackstagePassPolicy extends UpdatePolicy {
    public BackstagePassPolicy(ItemUpdater item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        if (item.sellDateHasPassed()) {
            setQualityToZeroAfterConcert();
        } else {
            increaseQualityBeforeConcert();
        }
    }

    private void setQualityToZeroAfterConcert() {
        item.setQualityToZero();
    }

    private void increaseQualityBeforeConcert() {
        if (item.sellInLessThan(5)) {
            item.incrementQuality();
        }
        if (item.sellInLessThan(10)) {
            item.incrementQuality();
        }
        item.incrementQuality();
    }
}
