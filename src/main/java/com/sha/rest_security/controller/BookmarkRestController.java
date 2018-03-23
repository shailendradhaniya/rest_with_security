package com.sha.rest_security.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sha.rest_security.domains.Bookmark;
import com.sha.rest_security.exception.UserNotFoundException;
import com.sha.rest_security.repository.AccountRepository;
import com.sha.rest_security.repository.BookmarkRepository;

@RestController
@RequestMapping("/{userId}/bookmarks")
public class BookmarkRestController {
	
	private final BookmarkRepository bookmarkRepository;
	
	private final AccountRepository accountRepository;

	@Autowired
	public BookmarkRestController(BookmarkRepository bookmarkRepository, AccountRepository accountRepository) {
		super();
		this.bookmarkRepository = bookmarkRepository;
		this.accountRepository = accountRepository;
	}
	
	  @RequestMapping(method = RequestMethod.GET)
		Collection<Bookmark> readBookmarks(@PathVariable String userId) {

			this.validateUser(userId);

			Collection<Bookmark> bookmarksList = bookmarkRepository
					.findByAccountUsername(userId);

			return bookmarksList;
		}
	
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@PathVariable String userId, @RequestBody Bookmark input) {
		this.validateUser(userId);

		return this.accountRepository.findByUsername(userId)
				.map(account -> {
					Bookmark result=bookmarkRepository.save(new Bookmark(account,input.getUri(), input.getDescription()));
					//Link forOneBookmark = new BookmarkResource(result);

					return ResponseEntity.ok(result);
				}).orElse(ResponseEntity.noContent().build());
				
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{bookmarkId}")
	public Bookmark readBookmark(@PathVariable String userId,
                                  @PathVariable Long bookmarkId) {
		this.validateUser(userId);
		return this.bookmarkRepository.findById(bookmarkId).get();
	}
	
	private void validateUser(String userId) {
		this.accountRepository.findByUsername(userId).orElseThrow(
				() -> new UserNotFoundException(userId));
	}
	
	

}
