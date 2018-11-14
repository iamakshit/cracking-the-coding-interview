package com.java.tech.ood.onlineBookReader;

public class OnlineSystem {

	Integer activeUserId;
	Integer bookId;
	Integer pageNumber;
	UserSystem userSystem;
	BookCatalog bookCatalog;

	OnlineSystem instance = null;

	public OnlineSystem getInstance() {
		if (instance == null) {
			instance = new OnlineSystem();
		}
		return instance;
	}

	private OnlineSystem() {
		setupOnlineSystem();
	}

	private void setupOnlineSystem() {
		bookCatalog = BookCatalog.getInstance();
		userSystem = UserSystem.getInstance();

	}

	public UserSystem getUserSystem() {
		return userSystem;
	}

	public void setUserSystem(UserSystem userSystem) {
		this.userSystem = userSystem;
	}

	public BookCatalog getBookCatalog() {
		return bookCatalog;
	}

	public void setBookCatalog(BookCatalog bookCatalog) {
		this.bookCatalog = bookCatalog;
	}

	public Integer getActiveUserId() {
		return activeUserId;
	}

	public void setActiveUserId(Integer activeUserId) {
		this.activeUserId = activeUserId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void readBook() {

	}

	public boolean isOnlineReadingAvailable() {
		return true;
	}

	public void holdBook() {

	}

	public void releaseBook() {

	}
}
