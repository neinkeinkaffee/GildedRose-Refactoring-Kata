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
                case "Aged Brie":
                    return this.item.sellIn >= 0 ? 1 : 2;
                case "Backstage passes to a TAFKAL80ETC concert":
                    return backstageTicketQualityDelta();
            }
            return this.item.sellIn >= 0 ? -1 : -2;
        }

        private int backstageTicketQualityDelta() {
            assert this.item.name.equals("Backstage passes to a TAFKAL80ETC concert");
            if (this.item.sellIn >= 10) {
                return 1;
            } else if (this.item.sellIn >= 5) {
                return 2;
            } else if (this.item.sellIn >= 0) {
                return 3;
            }
            return -this.item.quality;
        }
    }
}
