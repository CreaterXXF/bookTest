package model;


import java.util.List;

public class Member {
	private String Id;
	private String Name;
	private List<Loan> Loans;
	private List<ISpecification<Member>> iSpecifications;
	public List<Loan> getLoans() {
		return Loans;
	}
	public void setLoans(List<Loan> loans) {
		Loans = loans;
	}
	public List<ISpecification<Member>> getiSpecifications() {
		return iSpecifications;
	}
	public void setiSpecifications(List<ISpecification<Member>> iSpecifications) {
		this.iSpecifications = iSpecifications;
	}
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	 Loan FindCurrentLoanFor(Book book) {
	        for (Loan loan : this.Loans) {
	            if (loan.getBook().getISBN().equals(book.getISBN())
	                    && loan.getMember().getName().equals(book.getLoanTo().getName())) {
	                return loan;
	            }
	        }
	        return null;
	    }
	 public Loan returnBook(Book book) {
	        Loan loan = FindCurrentLoanFor(book);
	        loan.MarkAsReturn();
	        book.setLoanTo(null);
	        return loan;
	    }
	public Loan loan(Book book){
		Loan loan = null;
        if (CanLoan(book)) {
            LoanFactory loanFactory = new LoanFactory();
            loan = loanFactory.CreateLoan(book, this);
            Loans.add(loan);
        }
        return loan;
	}
	public final boolean CanLoan(Book book){
		 LoanOnlyOneSpecification.book = book;
	        if (book.getLoanTo() == null && validate()) {
	            return true;
	        } else {
	            return false;
	        }
	}
	boolean validate() {
        for (ISpecification iSpecification : iSpecifications) {
            if (iSpecification.isSatisfiedBy(this)) {
                return false;
            }
        }
        return true;
    }

	
}
