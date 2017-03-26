package com.localyokel.yokel.ListItems;

import com.localyokel.yokel.XmlParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 7201363 on 3/25/2017.
 */

public class GrowerContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<GrowerItem> ITEMS = new ArrayList<GrowerItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, GrowerItem> ITEM_MAP = new HashMap<String, GrowerItem>();

    static {
        GrowerItem[] items;

        XmlParser parser = new XmlParser();

        items = parser.parseGrowers();

        // Add some sample items.
        for (int i = 0; i < items.length; i++) {
            addItem(items[i]);
        }
    }

    private static void addItem(GrowerItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.name, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class GrowerItem {
        public String name;
        public String description;
        public String produces;
        public String location;

        public GrowerItem() {
            this.name ="test";
            this.description ="test";
            this.produces ="test";
            this.location ="test";
        }

        @Override
        public String toString() {
            return description;
        }
    }
}
