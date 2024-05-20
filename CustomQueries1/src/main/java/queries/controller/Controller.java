package queries.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import queries.controller.flights.FlightService;
import queries.controller.flights.Flights;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class Controller {

    private final FlightService flightService;

    public Controller(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/get-all")
    public List<Flights> getAll() {
        return flightService.getAll();
    }

    @PostMapping("/generate")
    public String generate() {
        flightService.generate();
        return "Generated";
    }


}