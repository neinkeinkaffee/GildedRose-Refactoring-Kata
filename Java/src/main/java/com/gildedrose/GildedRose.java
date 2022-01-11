package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdatePolicy policy = new ItemUpdatePolicy(item);
            item.updateSellIn(policy.sellInDelta());
            item.updateQuality(policy.qualityDelta());
        }
    }

    private static class ItemUpdatePolicy {
        private final Item item;

        public ItemUpdatePolicy(Item item) {
            this.item = item;
        }

        private int sellInDelta() {
            switch (this.item.name) {
                case "Sulfuras, Hand of Ragnaros":
                    return 0;
            }
            return -1;
        }

        private int qualityDelta() {
            switch (this.item.name) {
                case "Sulfuras, Hand of Ragnaros":
                    return 0;
                case "Backstage passes to a TAFKAL80ETC concert":
                    return this.item.sellIn < 0 ? -this.item.quality : backstagePassPreConcertQualityDelta();
                case "Aged Brie":
                    return this.item.sellIn < 0 ? 2 : 1;
                case "Conjured Mana Cake":
                    return this.item.sellIn < 0 ? -4 : -2;
            }
            return this.item.sellIn < 0 ? -2 : -1;
        }

        private int backstagePassPreConcertQualityDelta() {
            if (this.item.sellIn >= 10) {
                return 1;
            } else if (this.item.sellIn >= 5) {
                return 2;
            }
            return 3; // this.item.sellIn >= 0
        }
    }
}
