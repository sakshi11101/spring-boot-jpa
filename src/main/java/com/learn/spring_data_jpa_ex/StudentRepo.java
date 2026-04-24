package com.learn.spring_data_jpa_ex;

import com.learn.spring_data_jpa_ex.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository takes two fields, first which class we are dealing with and primary id type.
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
