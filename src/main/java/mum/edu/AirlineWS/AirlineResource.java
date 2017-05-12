package mum.edu.AirlineWS;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cs545.airline.dao.FlightDao;
import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/airline")
public class AirlineResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String welcome() {
		return "Welcome";
	}

	@Path("/flights")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flight> getflights() {
		try {
			FlightService flightService = new FlightService(new FlightDao());
			List<Flight> flights = flightService.findAll();
			return flights;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
