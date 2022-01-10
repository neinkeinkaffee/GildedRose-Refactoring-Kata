package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!"Sulfuras, Hand of Ragnaros".equals(item.name)) {
                item.updateSellIn(-1);
            }

            int updateDelta;
            switch (item.name) {
                case "Sulfuras, Hand of Ragnaros":
                    updateDelta = 0;
                    break;

                case "Aged Brie":
                    updateDelta = 2;
                    if (item.sellIn >= 0) {
                        updateDelta = 1;
                    }
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    updateDelta = -item.quality;
                    if (item.sellIn >= 10) {
                        updateDelta = 1;
                    } else if (item.sellIn >= 5) {
                        updateDelta = 2;
                    } else if (item.sellIn >= 0) {
                        updateDelta = 3;
                    }
                    break;

                default:
                    updateDelta = -2;
                    if (item.sellIn >= 0) {
                        updateDelta = -1;
                    }
                    break;
            }
            item.updateQuality(updateDelta);
        }
    }
}
