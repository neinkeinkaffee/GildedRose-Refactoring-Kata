package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateOneItem(item);
        }
    }

    private void updateOneItem(Item item) {
        ItemUpdateStrategy strategy = determineUpdateStrategy(item);
        strategy.updateSellIn(item);
        strategy.updateQuality(item);
    }

    private ItemUpdateStrategy determineUpdateStrategy(Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                return new LegendaryStrategy();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassStrategy();
            case "Aged Brie":
                return new BrieStrategy();
            case "Conjured Mana Cake":
                return new ConjuredStrategy();
        }
        return new ItemUpdateStrategy();
    }

    private class LegendaryStrategy extends ItemUpdateStrategy {
        public void updateSellIn(Item item) {
        }

        public void updateQuality(Item item) {
        }
    }

    private class BackstagePassStrategy extends ItemUpdateStrategy {
        public void updateQuality(Item item) {
            if (item.sellIn < 0) {
                item.quality = 0;
            } else {
                if (item.sellIn < 5) {
                    incrementQuality(item);
                }
                if (item.sellIn < 10) {
                    incrementQuality(item);
                }
                incrementQuality(item);
            }
        }
    }

    private class BrieStrategy extends ItemUpdateStrategy {
        public void updateQuality(Item item) {
            incrementQuality(item);
            if (item.sellIn < 0) {
                incrementQuality(item);
            }
        }
    }

    private class ConjuredStrategy extends ItemUpdateStrategy {
        public void updateQuality(Item item) {
            decrementQuality(item);
            decrementQuality(item);
            if (item.sellIn < 0) {
                decrementQuality(item);
                decrementQuality(item);
            }
        }
    }

    private class ItemUpdateStrategy {
        public void updateSellIn(Item item) {
            decrementSellIn(item);
        }

        public void updateQuality(Item item) {
            decrementQuality(item);
            if (item.sellIn < 0) {
                decrementQuality(item);
            }
        }
    }

    private void decrementSellIn(Item item) {
        item.sellIn -= 1;
    }

    private void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

    private void decrementQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }
}
