package car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepo extends JpaRepository<Car, Integer> {
    @Query(value = "select * from Car where id = ?", nativeQuery = true)
    Car getCarById(Integer id);
}