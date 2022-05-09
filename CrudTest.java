import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CrudTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Trying to read persistence.xml file...");
		
		//3
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("EntityManagerFactory created....");
		
		EntityManager em = emf.createEntityManager();
		System.out.println("EntityManager created....");
		
		EntityTransaction et = em.getTransaction();
		System.out.println("EntityTransaction created....");
		
		System.out.println("Trying to create record.....");
		Flight theFlight= new Flight();
		/*theFlight.setFlightNumber(103);
		theFlight.setFlightName("Air America");
		theFlight.setFlightSource("Delhi");
		theFlight.setFlightDestination("Mumbai");
		theFlight.setFlightTicketCost(7500);
		theFlight.setNumberOfPassengers(100);
		theFlight.setFlightDepartureFromSource(LocalDateTime.now());
		theFlight.setFlightArrivalDestination(LocalDateTime.now());*/
		
		//et.commit();
		System.out.println("=================");
		
		System.out.println("Getting a list of Objects.......");
		//et.begin();
		Query q = em.createNativeQuery("Select * from FlightDetail", Flight.class);
		List<Flight> f = (List<Flight>) q.getResultList();
		System.out.println("created.........."+f);
		
		for(Flight list:f) {
			
			System.out.println(list.getFlightNumber());	
		}
		
		System.out.println("List of objects displayed.......");
		
		/*et.begin();
			em.persist(theFlight);
		et.commit();
		System.out.println("=================");*/
		//et.begin();
			//Flight f = em.find(Flight.class, 69);
			//f.setFlightDestination("USA");
	        //	em.remove(f);
			//et.commit();
			//em.merge(f);
		
			
		
		
		
		//System.out.println("Created the record.....");
		
	}

}