package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class CollectionManager {

    public static Item getItemById(ArrayList<Item> collection, int id) {
        Boolean found = false;
        int index = 0;

        while (index < collection.size() && !found) {
            if (collection.get(index).getId() == id) {
                found = true;
            } else {
                index++;
            }
        }
        if (found)
            return collection.get(index);
        else
            return null;
    }

    public static List<String> getAvailableItems(ArrayList<Item> collection) {
        List<String> availableItems = new ArrayList<>();
        for (Item item: collection) {
            if (!item.isCheckout()) {
                availableItems.add(item.toString());
            }
        }
        return availableItems;
    }

    public static List<String> getUnavailableItems(ArrayList<Item> collection) {
        List<String> unavailableItems = new ArrayList<>();
        for (Item item: collection) {
            if (item.isCheckout()) {
                unavailableItems.add(item.statusToString());
            }
        }
        return unavailableItems;
    }

    public static String checkoutAvailableItem(int id, ArrayList<Item> collection, String code, String successMessage, String errorMessage) {
        try {
            Item selectedItem = CollectionManager.getItemById(collection, id);
            if (selectedItem == null) { return errorMessage; }
            if (selectedItem.isCheckout()) {
                return errorMessage;
            } else {
                selectedItem.checkout(code);
                return successMessage;
            }
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            return errorMessage;
        }
    }

    public static String returnItem(int id, ArrayList<Item> collection, String successMessage, String errorMessage) {
        try {
            Item selectedItem = CollectionManager.getItemById(collection, id);
            if (selectedItem == null) { return errorMessage; }
            if (selectedItem.isCheckout()) {
                selectedItem.checkin();
                return successMessage;
            } else {
                return errorMessage;
            }
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            return errorMessage;
        }
    }
}
