package com.gildedrose;

class GildedRose {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private static void updateItem(Item item) {
        int amountBy = 0;
        switch (item.name) {
            case "Aged Brie":
                if (item.sellIn > 0) {
                    amountBy = 1;
                } else {
                    amountBy = 2;
                }
                item.quality = Math.min(item.quality + amountBy, MAX_QUALITY);
                item.sellIn--;
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                if (item.sellIn > 10) {
                    amountBy = 1;
                } else if (item.sellIn > 5) {
                    amountBy = 2;
                } else if (item.sellIn > 0) {
                    amountBy = 3;
                } else {
                    item.quality = 0;
                }
                item.quality = Math.min(item.quality + amountBy, MAX_QUALITY);
                item.sellIn--;

                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            case "Conjured Mana Cake":
                if (item.sellIn > 0) {
                    amountBy = -2;
                } else {
                    amountBy = -4;
                }
                item.quality = Math.max(item.quality + amountBy, MIN_QUALITY);
                item.sellIn -= 1;
                break;
            default:
                if (item.sellIn > 0) {
                    amountBy = -1;
                } else {
                    amountBy = -2;
                }
                item.quality = Math.max(item.quality + amountBy, MIN_QUALITY);
                item.sellIn--;
                break;
        }
    }
}