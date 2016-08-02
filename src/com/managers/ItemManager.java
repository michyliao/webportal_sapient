package com.managers;

import java.util.Hashtable;
import java.util.UUID;

import com.interfaces.IPortal;
import com.portalObjects.*;

public class ItemManager implements IPortal<Item> {

	Hashtable<UUID, Item> itemList = new Hashtable<UUID, Item>();

	@Override
	public void add(Item projectItem) {
		UUID key = UUID.randomUUID();

		projectItem.setID(key);

		itemList.put(key, projectItem);
	}

	@Override
	public void print(Item projectItem) {
		System.out.println(projectItem);
	}

	@Override
	public Item find(String name) {
		Item returnProjectItem = null;

		for (Item projectItem : itemList.values()) {
			if (projectItem.getName().equals(name)) {
				returnProjectItem = projectItem;
			}
		}

		return returnProjectItem;
	}

	@Override
	public Hashtable<UUID, Item> returnAll() {
		return itemList;
	}

	@Override
	public void viewAll() {
		for (Item item : itemList.values()) {
			System.out.println(item);
		}
	}

}
