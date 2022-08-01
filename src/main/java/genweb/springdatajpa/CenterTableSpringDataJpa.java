package genweb.springdatajpa;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import genweb.domain.CenterTable;

@Repository
public interface CenterTableSpringDataJpa {

	@Transactional
	void save(CenterTable centerTable);
	
	List<Object[]> getCenterDetails();
	
	void updateCenterName(BigDecimal centerCode,String centerName);
	
	void deleteCenter(BigDecimal centerCode);
	
	List<Object[]> getCenterDetailAndUser(BigDecimal centerCode);

}
