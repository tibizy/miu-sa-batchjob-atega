package com.miusaatega.batchjob;

import net.bytebuddy.asm.Advice;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.Date;
import java.util.GregorianCalendar;

public class Processor implements ItemProcessor<Student, Student> {

    @Override
    public Student process(Student student) throws Exception {
        String firstName = student.getFirstName();
        String lastName = student.getLastName();
        double cgpa = student.getGpa();
        int age = student.getAge();
        LocalDate currentDate = LocalDate.now();
        LocalDate year = currentDate.minusYears(age);
        LocalDate dob = LocalDate.of(year.getYear(), Month.JANUARY, 01);

//        Student stud = new Student(firstName, lastName, cgpa, dob);
        //Change this to the previous line
        Student stud = new Student(firstName, lastName, cgpa, 1);
        return stud;
    }
}
