package in.app.lostFoundItem.service;

import java.util.List;

import in.app.lostFoundItem.entity.LostItem;

public interface LostItemService {
	public List<LostItem> fetchAllLostItems();
	public LostItem fetchLostItemsById(Integer id);
	public void deleteLostItemsById(Integer id);
	public void saveLostItems(LostItem lostItem);

}
