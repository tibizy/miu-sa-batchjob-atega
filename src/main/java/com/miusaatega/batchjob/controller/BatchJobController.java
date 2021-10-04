package com.miusaatega.batchjob.controller;

import com.miusaatega.batchjob.models.Student;
import com.miusaatega.batchjob.repository.StudentRepository;
import com.miusaatega.batchjob.services.BatchJobService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("api/admin")
@RolesAllowed("ADMIN")
@Tag(name = "Admin")
public class BatchJobController {

    @Autowired
    BatchJobService batchJobService;
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("jobs")
    public ResponseEntity<List<Student>> runJob() throws Exception {
        batchJobService.runJob();
        return ResponseEntity.ok(studentRepository.findAll());
    }
}
