package com.urolain.luckymoeny.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LuckymoneyDao extends JpaRepository<LuckymoneyDO,Long> {

    List<LuckymoneyDO> findAllBySender(Long sender);
}
