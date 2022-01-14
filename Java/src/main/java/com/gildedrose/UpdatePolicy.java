package com.gildedrose;

public abstract class UpdatePolicy {
    protected ItemUpdater item;

    public UpdatePolicy(ItemUpdater item) {
        this.item = item;
    }

    public void update() {
        updateSellIn();
        updateQuality();
    }

    protected abstract void updateQuality();

    protected void updateSellIn() {
        this.item.decrementSellIn();
    };
}
