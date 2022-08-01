package genweb.springdatajpaImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import genweb.domain.CenterTable;
import genweb.springdatajpa.CenterTableSpringDataJpa;

@Repository
public interface CenterTableSpringDataJpaRepository extends CenterTableSpringDataJpa,JpaRepository<CenterTable, BigDecimal> {
	
	@Override
	@Query(value=" select * from center_table ",nativeQuery=true)
	List<Object[]> getCenterDetails();

	@Override
	@Modifying
	@Transactional	
	@Query(value=" update center_table c " + 
			     " set c.CENTER_NAME=:centerName  " + 
			    " WHERE c.AREA_CODE=:areaCode ",nativeQuery=true)
	void updateCenterName(@Param("areaCode") BigDecimal areaCode, @Param("centerName") String centerName);
	
	@Override
	@Modifying
	@Transactional
	@Query(value=" delete from center_table c where c.AREA_CODE=:centerCode " ,nativeQuery=true)
	void deleteCenter(@Param("centerCode") BigDecimal centerCode);
	
	@Override
	@Query(value=" select * from center_table c where c.AREA_CODE=:centerCode ",nativeQuery=true)
	List<Object[]> getCenterDetailAndUser(@Param("centerCode") BigDecimal centerCode);
	
}
