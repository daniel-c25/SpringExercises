package hibernate.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Enrollments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long enrollmentId;
	
	@ManyToOne
	@JoinColumn
	private Students student;
	
	@ManyToOne
	@JoinColumn
	private Classes classe;

	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}

	public Classes getClasse() {
		return classe;
	}

	public void setClasse(Classes classe) {
		this.classe = classe;
	}

	public Long getEnrollmentId() {
		return enrollmentId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(classe, enrollmentId, student);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enrollments other = (Enrollments) obj;
		return Objects.equals(classe, other.classe) && Objects.equals(enrollmentId, other.enrollmentId)
				&& Objects.equals(student, other.student);
	}
}
