package model;

public class Book 
{
	private String ID;
	
	private String ISBN;
	
	private String Title;
	
	private Member loanTo;
	public Member getLoanTo()
	{
		return loanTo;
	}
	public void setLoanTo(Member loanTo)
	{
		this.loanTo=loanTo;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	
}
