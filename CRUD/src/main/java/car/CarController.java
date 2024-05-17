package car;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/cars")
public class CarController {

    private CarRepo carRepo;
    public CarController(CarRepo repo) {
        this.carRepo = repo;
    }

    @GetMapping
    public List<Car> getAll() {
        return carRepo.findAll();
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carRepo.save(car);
    }

    @GetMapping("/{id}")
    public Optional<Car> findById(@PathVariable("id") Integer id) {
        return carRepo.findById(id);
    }

    @PutMapping("/{id}")
    public Car updateType(@PathVariable("id") Integer id, @PathParam("type") String type) {
        Car car = carRepo.getCarById(id);
        return carRepo.save(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable("id") Integer id, HttpServletResponse res) {
        if (findById(id).isEmpty()) {
            res.setStatus(409);
            return;
        }
        carRepo.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        carRepo.deleteAll();
    }
}