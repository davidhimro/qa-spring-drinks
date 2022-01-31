package com.qa.wine.repo;

import com.qa.wine.domain.WineList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineListRepository extends JpaRepository<WineList, Long> {

}