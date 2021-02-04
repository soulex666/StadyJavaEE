package com.andreev.StadyJavaEE.fakeDB;

import com.andreev.StadyJavaEE.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemsDBManager {
    private static final List<Item> items = new ArrayList<>();
    private static Long id = 6L;

    private ItemsDBManager() {
    }

    static {
        items.add(new Item(1L, "IPhone", 120000, 45));
        items.add(new Item(2L, "Xiaomi", 20000, 21));
        items.add(new Item(3L, "Huaveu", 23000, 12));
        items.add(new Item(4L, "Samsung", 87000, 432));
        items.add(new Item(5L, "Sony", 3000, 442));
    }

    public static void addItem(Item item) {
        item.setId(id);
        items.add(item);
        id++;
    }

    public static List<Item> getItems() {
        return items;
    }

    public static Item getItem(Long id) {
        for(Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
