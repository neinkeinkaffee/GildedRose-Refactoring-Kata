package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @ParameterizedTest
    @CsvSource({
        "someItem, 0, 0, -1, 0", // ordinary item's quality deteriorates but not below 0
        "someItem, 1, 2, 0, 1",  // ordinary item's quality deteriorates by 1 while sellIn > 0
        "someItem, 0, 3, -1, 1", // item's quality deteriorates by 1 once sellIn <= 0
        "Aged Brie, 3, 4, 2, 5", // Aged Brie improves in quality
        "Aged Brie, -50, 50, -51, 50", // item's quality can't improve beyond 50
        "Aged Brie, 0, 10, -1, 12", // Aged Brie's quality increases by 2 once sellIn <= 0
        "Aged Brie, -3, 20, -4, 22", // Aged Brie's quality increases by 2 once sellIn <= 0
        "Backstage passes to a TAFKAL80ETC concert, 5, 10, 4, 13", // backstage passes where sellIn <= 5
        "Backstage passes to a TAFKAL80ETC concert, 10, 10, 9, 12", // backstage passes where 5 < sellIn <= 10
        "Backstage passes to a TAFKAL80ETC concert, 12, 10, 11, 11", // backstage passes where sellIn > 10
        "Backstage passes to a TAFKAL80ETC concert, 0, 10, -1, 0", // backstage passes after concert
        "'Sulfuras, Hand of Ragnaros', 0, 80, 0, 80", // Sulfuras never sell and their quality is constant
        "'Sulfuras, Hand of Ragnaros', -1, 80, -1, 80", // Sulfuras never sell and their quality is constant
        "Conjured Mana Cake, 3, 6, 2, 4", // Conjured items deteriorate twice as fast
        "Conjured Mana Cake, 1, 6, 0, 4", // Conjured items deteriorate twice as fast
        "Conjured Mana Cake, 0, 6, -1, 2", // Conjured items deteriorate twice as fast
    })
    void testUpdateQuality(String name, int sellIn, int quality, int updatedSellIn, int updatedQuality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(name, app.items[0].name);
        assertEquals(updatedSellIn, app.items[0].sellIn);
        assertEquals(updatedQuality, app.items[0].quality);
    }

}
