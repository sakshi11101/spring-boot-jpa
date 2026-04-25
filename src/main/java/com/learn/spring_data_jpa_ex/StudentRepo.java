package com.learn.spring_data_jpa_ex;

import com.learn.spring_data_jpa_ex.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//JpaRepository takes two fields, first which class we are dealing with and primary id type.
public interface StudentRepo extends JpaRepository<Student, Integer> {

    /* Inside @Query annotation - this is called JPQL query, similar to SQL query but instead
    of table name, entity class name is used along with where clause. The question mark is replaced by name parameter.
    In case of mutiple parameters after where clause and in method, then how do we know which question mark
    belongs to which method parameter, hence we use 1, 2....so on. Even without @Query it works here. */

    /* Without @Query every method will not run. JPA uses DSL (Domain-Specific Language) and internally
     behind the scenes it creates certain methods by looking at column names/property names and
     name, marks etc. and can use those methods directly. */

//    @Query("select s from Student s where s.name = ?1")
    List<Student> findByName(String name); //The method name findBy{mention the property/column of student to find by.}

    /*This method, basically certain queries that are part of JPQL/SQL queries those methods are pre-built behind the scenes.
    Similarly, less than, equals to also exist.*/
    List<Student> findByMarksGreaterThan(int marks);
}
