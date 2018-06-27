package model;

public class HasReachMaxSpecification implements ISpecification<Member>{
	@Override
    public boolean isSatisfiedBy(Member member) {
        return member.getLoans().size() >2;
    }
}
