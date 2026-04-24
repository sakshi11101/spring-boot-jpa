package com.learn.spring_data_jpa_ex;

import com.learn.spring_data_jpa_ex.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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

        //saves the info to database table.
        /*studentRepo.save(s1);
        studentRepo.save(s2);*/
        studentRepo.save(s3);
	}
}
