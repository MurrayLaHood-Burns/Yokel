package com.localyokel.yokel.ListItems;

import android.content.ClipData;

import com.localyokel.yokel.R;
import com.localyokel.yokel.XmlParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 7201363 on 3/25/2017.
 */

public class PackageContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<PackageItem> ITEMS = new ArrayList<PackageItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, PackageItem> ITEM_MAP = new HashMap<String, PackageItem>();

    private static final int COUNT = 25;

    static {

        PackageItem[] packageItems;

        XmlParser parser = new XmlParser();

        packageItems = parser.parsePackages();


        // Add some sample items.
        for (int i = 0; i < packageItems.length; i++) {

            addItem(packageItems[i]);
        }
    }

    private static void addItem(PackageItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.name, item);
        //ITEM_MAP.put(item.)
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class PackageItem {
        public String name;
        public String description;
        public String ingredients;
        public String price;
        public String image;

        public PackageItem() {
            this.name = "test";
            this.description = "test";
            this.ingredients = "test";
            this.price = "test";
            this.image = "hello1";
        }

        @Override
        public String toString() {
            return price;
        }
    }
}
