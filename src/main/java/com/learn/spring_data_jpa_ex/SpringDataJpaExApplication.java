package com.learn.spring_data_jpa_ex;

import com.learn.spring_data_jpa_ex.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaExApplication {

	public static void main(String[] args) {
        ApplicationContext applicationContext =  SpringApplication.run(SpringDataJpaExApplication.class, args);
        StudentRepo studentRepo = applicationContext.getBean(StudentRepo.class);

        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        s1.setRollNo(104);
        s2.setRollNo(105);
        s3.setRollNo(106);

        s1.setName("John");
        s2.setName("Kiran");
        s3.setName("Mohan");

        s1.setMarks(70);
        s2.setMarks(75);
        s3.setMarks(80);

        //1. saves the info to database table.
        /*studentRepo.save(s1);
        studentRepo.save(s2);
        studentRepo.save(s3);*/

        //2. fetch all records from database
        studentRepo.findAll().forEach(student -> {
            System.out.print(student.getRollNo() + " ");
            System.out.print(student.getName()+ " ");
            System.out.println(student.getMarks());
        });

        //3. Find by Id (primary key) from database
        /*int rollNo = 105;
        Optional<Student> studentById = studentRepo.findById(rollNo);   //find by Id returns an optional of student, in case that rollNo isn't present in DB so safe null check.
        String studentName = studentById.orElse(new Student()).getName();
        System.out.println("Name of student whose rollNo is : " + rollNo + " is " + studentName);

        //2nd way of dealing with optional - better
        if(studentById.isPresent()) {
            System.out.println("Name of student whose rollNo is : " + rollNo + " is " + studentName);
        } else {
            System.out.println("Roll No not found in database");
        }

        //3rd way to deal with optional - much better
        studentById.ifPresentOrElse(
                student -> System.out.println("Name of student whose rollNo is : " + rollNo + " is " + studentName),
                () -> System.out.println("Roll No not found in database")
        );
*/
        //3. Find by different parameter of student class rather than ID/primary key.
        /*List<Student> students = studentRepo.findByName("Kiran");
        students.forEach(student -> {
            System.out.print(student.getRollNo() + " ");
            System.out.print(student.getName()+ " ");
            System.out.println(student.getMarks());
        });*/

        /*List<Student> studentsMarks = studentRepo.findByMarksGreaterThan(72);
        studentsMarks.forEach(student -> {
            System.out.print(student.getRollNo() + " ");
            System.out.print(student.getName()+ " ");
            System.out.println(student.getMarks());
        });*/

        //4. Update - a select is fired first to check if row exists, if yes then update, else then create new row.
        /*s1.setMarks(65);
        studentRepo.save(s1);*/

        //5. Delete - same here, a select query is fired to check if row exists, if yes, then delete.
        /*studentRepo.delete(s1);*/

	}
}
