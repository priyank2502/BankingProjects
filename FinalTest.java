
public class FinalTest {

	public static void main(String[] args) {
		Bank b= new Bank();
		b.shortlistApplicant();
       HumanResourceManagement hrm = new HumanResourceManagement();
        hrm.allocateDepartment();

	}

}
 class Bank{
	        String Applicant;
	        int applicantMarks;
	final void shortlistApplicant() {
		
		System.out.println("Applicant is shortlisted......");
	}
	void hireApplicant() {
		System.out.println("Applicant is hired.......");
	}
}
class HumanResourceManagement extends Bank {
	void allocateDepartment()
	{
	super.hireApplicant();
	System.out.println("Department is allocated......");
	}
	
}