package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.StudentDao;
import org.example.dao.StudentDaoImpl;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("yashashvi");

        EntityManager em = emf.createEntityManager();

        StudentDao dao = new StudentDaoImpl(em);

        System.out.println("Saving Data...");
        dao.saveData();

        dao.fetchLaptopFromStudent(1);
        dao.fetchStudentFromLaptop(1);

        dao.updateLaptopBrand(1, "dell");
        dao.updateStudentCourse(1, "Computer Science");

        dao.changeLaptopForStudent(1, 2);
        dao.removeLaptopFromStudent(2);
        dao.deleteStudentAndLaptop(3);

        em.close();
        emf.close();

        System.out.println("Operations Completed.");
    }
}