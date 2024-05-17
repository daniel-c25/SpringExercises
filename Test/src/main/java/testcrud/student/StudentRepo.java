package testcrud.student;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    @Transactional
    @Modifying
    @Query(value = "update student set name = :name, surname = :surname, is_working = :isWorking where id = :id", nativeQuery = true)
    int updateStudent(@Param("id") Long id, @Param("name") String name, @Param("surname") String surname, @Param("isWorking") Boolean isWorking);

}