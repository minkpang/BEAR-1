package com.zootopia.bear.Search.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zootopia.bear.Search.service.SearchService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

	private final SearchService searchService;

	@GetMapping("/hashtag")
	public ResponseEntity<?> searchHashTag(@RequestParam String keyword) {
		return new ResponseEntity<>(searchService.searchHashTag(keyword), HttpStatus.OK);
	}

	@GetMapping("/beer")
	public ResponseEntity<?> searchBeer(@RequestParam String keyword) {
		return new ResponseEntity<>(searchService.searchBeer(keyword), HttpStatus.OK);
	}
}
