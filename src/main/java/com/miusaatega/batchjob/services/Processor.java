package com.miusaatega.batchjob.services;

import com.miusaatega.batchjob.models.Student;
import com.miusaatega.batchjob.models.StudentDto;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;
import java.time.Month;

public class Processor implements ItemProcessor<StudentDto, Student> {

    @Override
    public Student process(final StudentDto studentDto) throws Exception {
        LocalDate currentDate = LocalDate.now();
        LocalDate year = currentDate.minusYears(studentDto.getAge());
        LocalDate dob = LocalDate.of(year.getYear(), Month.JANUARY, 01);

        Student stud = new Student();
        stud.setFirstname(studentDto.getFirstName());
        stud.setLastname(studentDto.getLastName());
        stud.setGpa(studentDto.getGpa());
        stud.setDob(dob);

        return stud;
    }
}
