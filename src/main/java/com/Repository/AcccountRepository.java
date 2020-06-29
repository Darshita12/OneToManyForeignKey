package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.AccountEntity;

@Repository
public interface AcccountRepository extends JpaRepository<AccountEntity, Integer>{
	
}
