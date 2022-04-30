import java.time.LocalDate;
public class TestOverride {

	public static void main(String[] args) {
		Account a= new Account();
		a.withdraw(500);
		SavingsAcc s= new SavingsAcc();
		s.withdraw(600);
		FdAcc f = new FdAcc();
		f.withdraw(40000);
		
		Account ref = new Account();
		ref.withdraw(8000);
		
		ref = new SavingsAcc();
		ref.withdraw(8000);
		
		ref = new FdAcc();
		ref.withdraw(5200);
		
		ref= new FdAcc();
		
		if(ref instanceof FdAcc ) {
			System.out.println("Yes it is pointing.........");
		}else {
			System.out.println("No it is not pointing.........");
		}

	}

}

class Account{
	float balance =10000;
	void withdraw(float f1 ) {
		System.out.println("Account:withdraw()");
		balance=balance-f1;
	}

}
class SavingsAcc extends Account{
	void withdraw(float f2) {
		System.out.println("SavingsAccount:withdraw()");
		if(balance < f2) {
			throw new RuntimeException("funds insufficient...");
		}
		balance=balance-f2;
	}
}
	
	

class FdAcc extends SavingsAcc{
	int tenureYear=2022;  //2025
	void withdraw(float a) {
		int currentYear = LocalDate.now().getYear();
		if(tenureYear != currentYear) {
			throw new RuntimeException("Account not matured...cannot withdrwa....");
		}
		System.out.println("FixedDepositAccount:withdraw()");
		balance=balance-a;
	}
	
}
