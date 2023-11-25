package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/TestCall")
    public List<AttachPropPrimaryKey> testCall() {
        return AttachmentFileService.queryForDocuments(1001L, "Project docs.zip", "Gravity Works", "Lightening Power", 1L, "Big Generator");
    }
}
