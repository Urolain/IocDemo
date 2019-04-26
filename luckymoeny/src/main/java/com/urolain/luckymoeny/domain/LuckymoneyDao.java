package com.urolain.luckymoeny.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LuckymoneyDao extends JpaRepository<LuckymoneyDO,Long> {
}
