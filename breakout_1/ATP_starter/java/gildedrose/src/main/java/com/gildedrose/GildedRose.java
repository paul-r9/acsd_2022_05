package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            UpdateOneItem(i);
        }
    }

    private void UpdateOneItem(int i) {
        if (getsBetterWithAge(i)) {
            DontKnowWHatThisDoes(items[i].quality > 0, !items[i].name.equals("Sulfuras, Hand of Ragnaros"), i, items[i].quality - 1);
        } else {
            if (items[i].quality < 50) {
                items[i].quality = items[i].quality + 1;

                if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    DontKnowWHatThisDoes(items[i].sellIn < 11, items[i].quality < 50, i, items[i].quality + 1);

                    DontKnowWHatThisDoes(items[i].sellIn < 6, items[i].quality < 50, i, items[i].quality + 1);
                }
            }
        }

        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
            items[i].sellIn = items[i].sellIn - 1;
        }

        if (items[i].sellIn < 0) {
            if (!items[i].name.equals("Aged Brie")) {
                if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    DontKnowWHatThisDoes(items[i].quality > 0, !items[i].name.equals("Sulfuras, Hand of Ragnaros"), i, items[i].quality - 1);
                } else {
                    items[i].quality = items[i].quality - items[i].quality;
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;
                }
            }
        }
    }

    private boolean getsBetterWithAge(int i) {
        return !items[i].name.equals("Aged Brie")
                && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void DontKnowWHatThisDoes(boolean quality, boolean name, int i, int quality1) {
        if (quality) {
            if (name) {
                items[i].quality = quality1;
            }
        }
    }
}
