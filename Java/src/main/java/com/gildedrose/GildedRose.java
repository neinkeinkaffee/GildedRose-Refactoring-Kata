package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            item.updateSellIn(sellInDelta(item));
            item.updateQuality(qualityDelta(item));
        }
    }

    private static int sellInDelta(Item item) {
        if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
            return 0;
        }
        return -1;
    }

    private static int qualityDelta(Item item) {
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
        if (item.sellIn >= 10) {
            return 1;
        } else if (item.sellIn >= 5) {
            return 2;
        } else if (item.sellIn >= 0) {
            return 3;
        }
        return -item.quality;
    }
}
