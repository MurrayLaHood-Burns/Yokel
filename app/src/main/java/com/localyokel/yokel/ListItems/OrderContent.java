package com.localyokel.yokel.ListItems;

import com.localyokel.yokel.XmlParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 7201363 on 3/25/2017.
 */

public class OrderContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<OrderItem> ITEMS = new ArrayList<OrderItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, OrderItem> ITEM_MAP = new HashMap<String, OrderItem>();

    private static final int COUNT = 2;

    static {
        // Add some sample items.
        OrderItem[] items;

        XmlParser parser = new XmlParser();

        items = parser.parseOrders();

        for (int i = 0; i < items.length; i++) {
            addItem(items[i]);
        }
    }

    private static void addItem(OrderItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.packageName, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class OrderItem {
        public String packageName;
        public String summary;
        public String deliveryDate;
        public String price;

        public OrderItem() {
            this.packageName="test";
            this.summary="test";
            this.deliveryDate="test";
            this.price="test";
        }

        @Override
        public String toString() {
            return summary;
        }
    }
}
