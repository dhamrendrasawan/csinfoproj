package genweb.springdatajpaImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import genweb.domain.UserDetails;
import genweb.springdatajpa.UserDetailsSpringDataJpa;

@Repository
public interface UserDetailsSpringDataJpaRepository extends UserDetailsSpringDataJpa, JpaRepository<UserDetails, BigDecimal> {

	@Override
	@Query(value=" select count(*) from user_Details  u where u.AREA_CODE=:areaCode ",nativeQuery=true)
	BigDecimal getUserCountByAreadCode(@Param("areaCode") String areaCode);
	
	@Override
	@Query(value=" select * from user_Details u where u.AREA_CODE=:areaCode ",nativeQuery=true)	
	List<Object[]> getUserDetails(@Param("areaCode") String areaCode);
	
}
