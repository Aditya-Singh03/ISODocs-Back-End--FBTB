package com.example.demo;


import com.example.demo.ZipService;
import com.example.Model.zipReturn;

import org.checkerframework.checker.units.qual.t;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@SpringBootTest
public class ZipServiceTests {

    private final ZipRepository zipRepository;

    @Autowired
    public ZipServiceTests(ZipRepository zipRepository) {
        this.zipRepository = zipRepository;
    }

    @Test
    public void getZipFilesTest() {
        zipReturn zipReturn = new zipReturn(null);
        assertEquals(null, zipReturn.getZipFiles(), "ZipFiles is null");
    }

    @Test
    public void setZipFilesTest() {
        zipReturn zipReturn = new zipReturn(null);
        zipReturn.setFiles(null);
        assertEquals(null, zipReturn.getZipFiles(), "ZipFiles is null");
    }

}