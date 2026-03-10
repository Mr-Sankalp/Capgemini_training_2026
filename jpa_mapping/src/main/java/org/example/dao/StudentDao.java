package org.example.dao;

public interface StudentDao {

    void saveData();

    void fetchLaptopFromStudent(int studentId);

    void fetchStudentFromLaptop(int laptopId);

    void updateLaptopBrand(int laptopId, String newBrand);

    void updateStudentCourse(int studentId, String newCourse);

    void changeLaptopForStudent(int studentId, int newLaptopId);

    void removeLaptopFromStudent(int studentId);

    void deleteStudentAndLaptop(int studentId);
}