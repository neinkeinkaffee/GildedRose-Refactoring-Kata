package com.gildedrose;

class GildedRose {
    private final QualityChangeRatePolicy qualityPolicy;
    private final SalesPolicy salesPolicy;
    Item[] items;

    public GildedRose(Item[] items) {
        qualityPolicy = new QualityChangeRatePolicy();
        salesPolicy = new SalesPolicy();
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateSellIn(item);
            updateQuality(item);
        }
    }

    private void updateSellIn(Item item) {
        item.sellIn += salesPolicy.delta(item);
    }

    private void updateQuality(Item item) {
        int delta = qualityPolicy.delta(item);
        if (delta == 0) return;
        if (delta < 0) {
            item.quality = Math.max(0, item.quality + delta);
        } else {
            item.quality = Math.min(50, item.quality + delta);
        }
    }

    private static class QualityChangeRatePolicy {
        private int delta(Item item) {
            switch (item.name) {
                case "Sulfuras, Hand of Ragnaros":
                    return 0;
                case "Backstage passes to a TAFKAL80ETC concert":
                    return item.sellIn < 0 ? -item.quality : backstagePassPreConcertQualityDelta(item);
                case "Aged Brie":
                    return item.sellIn < 0 ? 2 : 1;
                case "Conjured Mana Cake":
                    return item.sellIn < 0 ? -4 : -2;
            }
            return item.sellIn < 0 ? -2 : -1;
        }

        private int backstagePassPreConcertQualityDelta(Item item) {
            if (item.sellIn >= 10) {
                return 1;
            } else if (item.sellIn >= 5) {
                return 2;
            }
            return 3; // item.sellIn >= 0
        }
    }

    private class SalesPolicy {
        private int delta(Item item) {
            switch (item.name) {
                case "Sulfuras, Hand of Ragnaros":
                    return 0;
            }
            return -1;
        }
    }
}
