package in.app.lostFoundItem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.app.lostFoundItem.entity.LostItem;
import in.app.lostFoundItem.exception.ItemNotFoundException;
import in.app.lostFoundItem.repository.LostItemRepository;
import in.app.lostFoundItem.service.LostItemService;

@RestController
public class LostNFoundController {
	@Autowired
	@Qualifier("lostItemServiceImpl")
	private LostItemService lostItemService;
	
	

	@GetMapping("/display")
	public ArrayList<String> displayAll() {
		ArrayList<String> a = new ArrayList<>();
		a.add("reshma");
		a.add("seshma");
		a.add("sseshma");
		return a;
	}
	

	@GetMapping("/AllLostItems")
	public List<LostItem> fetchAllLostItems() {
		return lostItemService.fetchAllLostItems();

	}
	

	@GetMapping("/LostItems/{id}")
	public LostItem fetchAllLostItemsByID(@PathVariable("id") Integer id) throws ItemNotFoundException {
		LostItem lostItem=	lostItemService.fetchLostItemsById(id);
		if(null == lostItem) {
			throw new ItemNotFoundException("No Item found ");
		}
		return lostItemService.fetchLostItemsById(id);
	}
	
	@DeleteMapping("/LostItems/{id}")
	public void deleteLostItemsByID(@PathVariable("id") Integer id) {
		 lostItemService.deleteLostItemsById(id);
	}


	@PostMapping("/LostItems/save")
	public void saveLostItems(@RequestBody LostItem lostItem) {
		 lostItemService.saveLostItems(lostItem);
	}
	
	@PutMapping("/LostItems/update/{id}")
	public void updateLostItems(@RequestBody LostItem lostItem,@PathVariable("id") Integer id) {
		LostItem lostItemObject=lostItemService.fetchLostItemsById(id);
		if(null == lostItemObject) {
			
		}else {
			lostItem.setLostId(id);
		 lostItemService.saveLostItems(lostItem);
		}
	}

}
