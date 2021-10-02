package com.miusaatega.batchjob;

import com.miusaatega.batchjob.services.BatchJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchJobController {

    @Autowired
    BatchJobService batchJobService;

    @PostMapping("jobs")
    public ResponseEntity runJob() {
        batchJobService.runJob();
        return new ResponseEntity(HttpStatus.OK);
    }
}
