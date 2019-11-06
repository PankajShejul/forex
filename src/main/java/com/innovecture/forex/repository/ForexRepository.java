package com.innovecture.forex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innovecture.forex.model.Forex;
import com.innovecture.forex.model.*;

@Repository
public interface ForexRepository extends JpaRepository<Forex,Long>{
	public Forex findByToCurrency(String currency);

}
