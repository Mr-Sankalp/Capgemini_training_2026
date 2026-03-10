package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entity.Laptop;
import org.example.entity.Student;

public class StudentDaoImpl implements StudentDao {

    private final EntityManager em;

    public StudentDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void saveData() {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Laptop l1 = new Laptop();
        l1.setBrand("Dell");
        l1.setPrice(75000);

        Laptop l2 = new Laptop();
        l2.setBrand("HP");
        l2.setPrice(65000);

        Laptop l3 = new Laptop();
        l3.setBrand("Lenovo");
        l3.setPrice(70000);

        Student s1 = new Student();
        s1.setName("A");
        s1.setCourse("Engineering");

        Student s2 = new Student();
        s2.setName("B");
        s2.setCourse("MBA");

        Student s3 = new Student();
        s3.setName("C");
        s3.setCourse("BCA");

        s1.setLaptop(l1);
        l1.setStudent(s1);

        s2.setLaptop(l2);
        l2.setStudent(s2);

        s3.setLaptop(l3);
        l3.setStudent(s3);

        em.persist(l1);
        em.persist(l2);
        em.persist(l3);

        em.persist(s1);
        em.persist(s2);
        em.persist(s3);

        tx.commit();
    }

    @Override
    public void fetchLaptopFromStudent(int studentId) {
        Student student = em.find(Student.class, studentId);
        if (student != null) {
            System.out.println(student.getLaptop());
        }
    }

    @Override
    public void fetchStudentFromLaptop(int laptopId) {
        Laptop laptop = em.find(Laptop.class, laptopId);
        if (laptop != null) {
            System.out.println(laptop.getStudent());
        }
    }

    @Override
    public void updateLaptopBrand(int laptopId, String newBrand) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Laptop laptop = em.find(Laptop.class, laptopId);
        if (laptop != null) {
            laptop.setBrand(newBrand);
        }

        tx.commit();
    }

    @Override
    public void updateStudentCourse(int studentId, String newCourse) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Student student = em.find(Student.class, studentId);
        if (student != null) {
            student.setCourse(newCourse);
        }

        tx.commit();
    }

    @Override
    public void changeLaptopForStudent(int studentId, int newLaptopId) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Student student = em.find(Student.class, studentId);
        if (student == null) {
            tx.rollback();
            throw new IllegalArgumentException("Student not found");
        }

        Laptop newLaptop = em.find(Laptop.class, newLaptopId);

        // If laptop does not exist → create new
        if (newLaptop == null) {
            newLaptop = new Laptop();
            newLaptop.setBrand("AutoCreated");
            newLaptop.setPrice(50000);
            em.persist(newLaptop);
        }

        // Detach old laptop from student
        Laptop oldLaptop = student.getLaptop();
        if (oldLaptop != null) {
            oldLaptop.setStudent(null);
        }

        // If new laptop already has a student → detach that student
        Student existingStudent = newLaptop.getStudent();
        if (existingStudent != null) {
            existingStudent.setLaptop(null);
        }

        // Assign new relationship
        student.setLaptop(newLaptop);
        newLaptop.setStudent(student);

        tx.commit();
    }

    @Override
    public void removeLaptopFromStudent(int studentId) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Student student = em.find(Student.class, studentId);

        if (student != null && student.getLaptop() != null) {
            Laptop laptop = student.getLaptop();
            student.setLaptop(null);
            laptop.setStudent(null);
        }

        tx.commit();
    }

    @Override
    public void deleteStudentAndLaptop(int studentId) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Student student = em.find(Student.class, studentId);

        if (student != null) {
            Laptop laptop = student.getLaptop();

            if (laptop != null) {
                student.setLaptop(null);
                laptop.setStudent(null);
                em.remove(laptop);
            }
            em.remove(student);
        }
        tx.commit();
    }
}