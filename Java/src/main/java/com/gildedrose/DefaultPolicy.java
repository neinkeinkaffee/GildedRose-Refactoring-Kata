package com.gildedrose;

class DefaultPolicy extends UpdatePolicy {
    public DefaultPolicy(ItemUpdater item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        item.decrementQuality();
        if (item.sellDateHasPassed()) {
            item.decrementQuality();
        }
    }
}
