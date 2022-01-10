package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void decreaseQuality(int delta) {
        this.quality = Math.max(0, this.quality - delta);
    }

    public void increaseQuality(int delta) {
        this.quality = Math.min(50, this.quality + delta);
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
