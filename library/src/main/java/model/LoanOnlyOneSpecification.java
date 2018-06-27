package model;

public class LoanOnlyOneSpecification implements ISpecification<Member>{
	static Book book;

    @Override
    public boolean isSatisfiedBy(Member member) {
        for (Loan loan : member.getLoans()) {
            if (loan.getBook().getISBN().equals(book.getISBN())) {
                return true;
            }
        }
        return false;
    }

}
