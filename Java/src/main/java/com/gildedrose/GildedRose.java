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
        ItemUpdater updater = createUpdater(item);
        updater.update(item);
    }

    private ItemUpdater createUpdater(Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                return new LegendaryUpdater();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassUpdater();
            case "Aged Brie":
                return new BrieUpdater();
            case "Conjured Mana Cake":
                return new ConjuredUpdater();
        }
        return new ItemUpdater();
    }
}
