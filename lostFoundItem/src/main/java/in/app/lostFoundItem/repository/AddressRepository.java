package in.app.lostFoundItem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.app.lostFoundItem.entity.Address;
import in.app.lostFoundItem.entity.Employee;
@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	List<Address> findByState(String state);

}
