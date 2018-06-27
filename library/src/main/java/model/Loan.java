package model;

import java.time.LocalDateTime;

public class Loan {
	private String Id;
	private LocalDateTime LoanTime;
	private LocalDateTime DateForReturn;
	private LocalDateTime ReturnDate;
	private Book Book;
	private Member Member;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public LocalDateTime getLoanTime() {
		return LoanTime;
	}
	public void setLoanTime(LocalDateTime loanTime) {
		LoanTime = loanTime;
	}
	public LocalDateTime getDateForReturn() {
		return DateForReturn;
	}
	public void setDateForReturn(LocalDateTime dateForReturn) {
		DateForReturn = dateForReturn;
	}
	public LocalDateTime getReturnDate() {
		return ReturnDate;
	}
	public void setReturnDate(LocalDateTime returnDate) {
		ReturnDate = returnDate;
	}
	public Book getBook() {
		return Book;
	}
	public void setBook(Book book) {
		Book = book;
	}
	public Member getMember() {
		return Member;
	}
	public void setMember(Member member) {
		Member = member;
	}
	public Boolean HasNotBeenReturn()
	{
		return ReturnDate==null;
	}
	public void MarkAsReturn()
	{
		ReturnDate=LocalDateTime.now();
	}
}
