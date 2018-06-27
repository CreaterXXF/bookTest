package model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BookTest {

    @Test
    public void testLoan() throws Exception {

        Member member = new Member();
        member.setId("a1");
        member.setName("xxf");

        Book searchBook = new Book();
        searchBook.setID("1");
        searchBook.setISBN("IBSN-NO01");
        searchBook.setTitle("God");

        Book book = new Book();
        book.setID("2");
        book.setISBN("IBSO-NO02");
        book.setTitle("ASD");
        book.setLoanTo(member);

        Book book1 = new Book();
        book1.setID("3");
        book1.setISBN("IBSO-NO03");
        book1.setTitle("qwe");
        book1.setLoanTo(member);
        
/*        Book book2 = new Book();
        book1.setID("4");
        book1.setISBN("IBSO-NO04");
        book1.setTitle("QAZ");
        book1.setLoanTo(member);
*/
        List<Loan> loans = new ArrayList<Loan>();
        Loan loan = new Loan();
        loan.setId("1");
        loan.setMember(member);
        loan.setBook(book);

        Loan loan1 = new Loan();
        loan1.setId("2");
        loan1.setMember(member);
        loan1.setBook(book1);
        
/*        Loan loan2 = new Loan();
        loan.setId("3");
        loan.setMember(member);
        loan.setBook(book2);
*/
        loans.add(loan);
        loans.add(loan1);
 //       loans.add(loan2);


        member.setLoans(loans);
        List<ISpecification<Member>> iSpecifications = new ArrayList<>();
        iSpecifications.add(new HasReachMaxSpecification());
        iSpecifications.add(new LoanOnlyOneSpecification());
        member.setiSpecifications(iSpecifications);
        Loan loan3 = member.loan(searchBook);
        if (loan3 == null) {
            System.out.print("你已不能借书");
        } else {
            System.out.print(loan3.getBook().getTitle() + "借书成功");
        }

    }

    @Test
    public void testReturnBook() throws Exception {
        Member member = new Member();
        member.setId("a02");
        member.setName("xxf");

        Book returnBook = new Book();
        returnBook.setID("2");
        returnBook.setISBN("IBSN-NO02");
        returnBook.setTitle("QWE");
        returnBook.setLoanTo(member);

        Book book = new Book();
        book.setID("2");
        book.setISBN("IBSN-NO02");
        book.setTitle("QWE");
        book.setLoanTo(member);

        Book book1 = new Book();
        book1.setID("3");
        book1.setISBN("IBSN-NO03");
        book1.setTitle("ZXC");
        book1.setLoanTo(member);

        Book book2 = new Book();
        book2.setID("4");
        book2.setISBN("IBSN-NO04");
        book2.setTitle("QAZ");
        book2.setLoanTo(member);

        List<Loan> loans = new ArrayList<Loan>();
        Loan loan = new Loan();
        loan.setId("1");
        loan.setMember(member);
        loan.setBook(book);

        Loan loan1 = new Loan();
        loan1.setId("2");
        loan1.setMember(member);
        loan1.setBook(book1);

        Loan loan2 = new Loan();
        loan2.setId("3");
        loan2.setMember(member);
        loan2.setBook(book2);

        loans.add(loan);
        loans.add(loan1);
        loans.add(loan2);

        member.setLoans(loans);
        Loan loan3 = member.returnBook(returnBook);
        System.out.print(loan3.getBook().getTitle()+"还书成功");
    }
}