package com.zootopia.bear.Beer.repository;

import java.util.List;

import com.zootopia.bear.rank.dto.RankDto;

public interface BeerRepositoryCustom {
	List<RankDto> rankAll();
	List<RankDto> rankByCategory(String category);
}
