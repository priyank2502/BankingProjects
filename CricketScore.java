
public class CricketScore {

	public static void main(String[] args) {
       Total t = new Total();
       t.f1();
       t.f2(100,50);   
       int score1 = t.f3(200,100);
       System.out.println("score1..."+score1);
       
       int score2 = t.f4();
       System.out.println("score2..."+score2);

	}

}

class Total
{
	public void f1() {
		int virat = 50;
		int rahul = 80;
		int result = virat + rahul ;
		System.out.println("virat is "+virat);
		System.out.println("rahul  is "+rahul);
		System.out.println("result is "+result);
		System.out.println("-------------------");
	}
	
	public void f2(int virat , int rahul) 
	{
		int result =virat +  rahul;
		System.out.println("virat is "+virat);
		System.out.println("rahul  is "+rahul);
		System.out.println("result is "+result);
		System.out.println("-------------------");
	}
	
	public int f3 (int virat, int rahul) {
		int result = virat + rahul;
		System.out.println("virat is "+virat);
		System.out.println("rahul  is "+rahul);
		return result;
		
		
		
	}
	public int f4() {
		int virat = 50;
		int rahul = 80;
		int result = virat + rahul ;
		System.out.println("virat is "+virat);
		System.out.println("rahul  is "+rahul);
		return result;
	}
}
