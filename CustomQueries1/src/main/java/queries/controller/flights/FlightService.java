package queries.controller.flights;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class FlightService {
    private final FlightsDao flightsDao;

    private final Random random = new Random();

    public FlightService(FlightsDao flightsDao) {
        this.flightsDao = flightsDao;
    }

    public List<Flights> getAll() {
        return flightsDao.findAll();
    }

    public void generate() {
        for (int i = 0; i < 50; i ++) {
            flightsDao.save(Flights.FlightsBuilder.aFlights().withDescription(UUID.randomUUID().toString()).withFromAirport(UUID.randomUUID().toString()).withToAirport(UUID.randomUUID().toString()).build());
        }
    }

	public Random getRandom() {
		return random;
	}
}