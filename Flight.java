import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FlightDetail")
public class Flight {
     @Id
     @GeneratedValue
	private int flightNumber;
	private String flightName;
	private String flightSource;
	private String flightDestination;
	private float flightTicketCost;
	private int numberOfPassengers;
	private LocalDateTime flightDepartureFromSource;
	private LocalDateTime flightArrivalDestination;

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFlightSource() {
		return flightSource;
	}

	public void setFlightSource(String flightSource) {
		this.flightSource = flightSource;
	}

	public String getFlightDestination() {
		return flightDestination;
	}

	public void setFlightDestination(String flightDestination) {
		this.flightDestination = flightDestination;
	}

	public float getFlightTicketCost() {
		return flightTicketCost;
	}

	public void setFlightTicketCost(float flightTicketCost) {
		this.flightTicketCost = flightTicketCost;
	}

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

	public LocalDateTime getFlightDepartureFromSource() {
		return flightDepartureFromSource;
	}

	public void setFlightDepartureFromSource(LocalDateTime flightDepartureFromSource) {
		this.flightDepartureFromSource = flightDepartureFromSource;
	}

	public LocalDateTime getFlightArrivalDestination() {
		return flightArrivalDestination;
	}

	public void setFlightArrivalDestination(LocalDateTime flightArrivalDestination) {
		this.flightArrivalDestination = flightArrivalDestination;
	}

}
