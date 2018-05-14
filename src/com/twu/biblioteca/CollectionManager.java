package com.twu.biblioteca;

import java.util.ArrayList;

public class CollectionManager {

    public static Item getItemById(ArrayList<Item> collection, int id) {
        Boolean found = false;
        int index = 0;

        while (!found) {
            if (collection.get(index).getId() == id) {
                found = true;
            } else {
                index++;
            }
        }
        return collection.get(index);
    }
}
