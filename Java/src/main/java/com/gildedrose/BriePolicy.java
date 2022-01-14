package com.gildedrose;

class BriePolicy extends UpdatePolicy {
    public BriePolicy(ItemUpdater item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        item.incrementQuality();
        if (item.sellDateHasPassed()) {
            item.incrementQuality();
        }
    }
}
