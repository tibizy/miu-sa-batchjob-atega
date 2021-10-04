package com.miusaatega.batchjob.repository;

import com.miusaatega.batchjob.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Modifying
    @Query(
            value = "truncate table student",
            nativeQuery = true
    )
    void truncateMyTable();
}
