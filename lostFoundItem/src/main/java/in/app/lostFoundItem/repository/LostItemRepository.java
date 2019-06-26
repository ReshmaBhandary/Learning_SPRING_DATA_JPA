package in.app.lostFoundItem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.app.lostFoundItem.entity.LostItem;
@Repository
public interface LostItemRepository extends JpaRepository<LostItem, Integer>{

}
