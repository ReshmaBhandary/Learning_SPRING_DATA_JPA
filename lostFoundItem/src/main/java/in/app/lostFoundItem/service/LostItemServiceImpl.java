package in.app.lostFoundItem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.app.lostFoundItem.entity.LostItem;
import in.app.lostFoundItem.repository.LostItemRepository;

@Service("lostItemServiceImpl")
public class LostItemServiceImpl implements LostItemService {
	@Autowired
	private LostItemRepository repository;

	@Override
	public List<LostItem> fetchAllLostItems() {
		return repository.findAll();
	}

	@Override
	public LostItem fetchLostItemsById(Integer id) {
		Optional<LostItem> lostItem = repository.findById(id);
		if (lostItem.isPresent()) {
			return lostItem.get();
		}
		return null;
	}

	@Override
	public void deleteLostItemsById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public void saveLostItems(LostItem lostItem) {
		repository.saveAndFlush(lostItem);		
	}

}
