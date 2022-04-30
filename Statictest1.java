class Platform
{
	void arriveAtPlatform(Train t1, Train t2, Train t3)
	{
		if(t1.getHourOfTheDay() < t2.getHourOfTheDay()) {
			System.out.println("t1 is allowed first...");
			
		} else
		{
			System.out.println("t2 is allowed...");
		}
				
	}
}

class Train {
	String trainColor;
	String passenger;
	int numberOfCompartment;
	boolean runningStatus;
	int hourOfTheDay;
	
	static int Traincount;

	public Train(String trainColor, String passenger, int numberOfCompartment, boolean runningStatus) {
		super();
		this.trainColor = trainColor;
		this.passenger = passenger;
		this.numberOfCompartment = numberOfCompartment;
		this.runningStatus = runningStatus;
	}

	void running() {
		System.out.println(trainColor + " color train is running..... " + passenger + " numberOfCompartment is " + numberOfCompartment
				+ " running status " + runningStatus);
	}
	

	public int getHourOfTheDay() {
		return hourOfTheDay;
	}

	public void setHourOfTheDay(int hourOfTheDay) {
		this.hourOfTheDay = hourOfTheDay;
	}
	
	
	 
}
public class Statictest1 {
	public static void main (String[]args){
		
		Train t1 = new Train ("Red","Priya",5,true);
		Train t2 = new Train ("Blue","Deepesh",8,true);
		Train t3 = new Train ("Green","Shikha",7, true);
		
		t1.setHourOfTheDay(10);
		t2.setHourOfTheDay(11);
		t3.setHourOfTheDay(12);
		
		t1.running(); 
		t2.running();
		t3.running();
		System.out.println("Train count is "+Train.Traincount);
	
		
	}
	
	

}

