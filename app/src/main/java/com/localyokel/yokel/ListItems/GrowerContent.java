package com.localyokel.yokel.ListItems;

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

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(GrowerItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.name, item);
    }

    private static GrowerItem createDummyItem(int position) {
        return new GrowerItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class GrowerItem {
        public final String name;
        public final String description;
        public final String produces;

        public GrowerItem(String id, String content, String details) {
            this.name = id;
            this.description = content;
            this.produces = details;
        }

        @Override
        public String toString() {
            return description;
        }
    }
}
