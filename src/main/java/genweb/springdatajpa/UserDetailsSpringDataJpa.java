package genweb.springdatajpa;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import genweb.domain.UserDetails;

@Repository
public interface UserDetailsSpringDataJpa {
	
	@Transactional
	void save(UserDetails userDetails);
	
	BigDecimal getUserCountByAreadCode(String areaCode);
	
	List<Object[]> getUserDetails(String areaCode);

}
