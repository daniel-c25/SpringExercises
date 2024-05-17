package testcrud.student;

import jakarta.persistence.*;

@Table(name = "student")
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private Boolean isWorking;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Boolean isWorking() {
        return isWorking;
    }

    public void setWorking(Boolean working) {
        isWorking = working;
    }


    public static final class StudentBuilder {

        private Long id;
        private String name;
        private String surname;
        private Boolean isWorking;

        private StudentBuilder() {
        }

        public static StudentBuilder aStudent() {
            return new StudentBuilder();
        }

        public StudentBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public StudentBuilder withName(String nome) {
            this.name = nome;
            return this;
        }

        public StudentBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public StudentBuilder withIsWorking(Boolean isWorking) {
            this.isWorking = isWorking;
            return this;
        }

        public Student build() {
            Student student = new Student();
            student.setName(name);
            student.setSurname(surname);
            student.setWorking(isWorking);
            student.id = this.id;
            return student;
        }
    }
}