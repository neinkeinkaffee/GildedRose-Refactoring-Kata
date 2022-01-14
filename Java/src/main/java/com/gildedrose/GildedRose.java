package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(this::updateOneItem);
    }

    private void updateOneItem(Item item) {
        UpdatePolicy updatePolicy = createUpdatePolicy(item);
        updatePolicy.update();
    }

    private UpdatePolicy createUpdatePolicy(Item item) {
        ItemUpdater itemUpdater = new ItemUpdater(item);
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                return new LegendaryPolicy(itemUpdater);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassPolicy(itemUpdater);
            case "Aged Brie":
                return new BriePolicy(itemUpdater);
            case "Conjured Mana Cake":
                return new ConjuredPolicy(itemUpdater);
        }
        return new DefaultPolicy(itemUpdater);
    }

}
