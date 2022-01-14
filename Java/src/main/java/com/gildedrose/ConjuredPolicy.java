package com.gildedrose;

class ConjuredPolicy extends UpdatePolicy {
    public ConjuredPolicy(ItemUpdater item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        item.decrementQuality();
        item.decrementQuality();
        if (item.sellDateHasPassed()) {
            item.decrementQuality();
            item.decrementQuality();
        }
    }
}
