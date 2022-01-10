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
            int qualityDelta = determineQualityDelta(item);
            item.updateQuality(qualityDelta);
        }
    }

    private static int determineQualityDelta(Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                return 0;
            case "Aged Brie":
                return item.sellIn >= 0 ? 1 : 2;
            case "Backstage passes to a TAFKAL80ETC concert":
                return determineBackstageUpdateDelta(item);
            default:
                return item.sellIn >= 0 ? -1 : -2;
        }
    }

    private static int determineBackstageUpdateDelta(Item item) {
        assert item.name.equals("Backstage passes to a TAFKAL80ETC concert");
        int updateDelta = -item.quality;
        if (item.sellIn >= 10) {
            updateDelta = 1;
        } else if (item.sellIn >= 5) {
            updateDelta = 2;
        } else if (item.sellIn >= 0) {
            updateDelta = 3;
        }
        return updateDelta;
    }
}
