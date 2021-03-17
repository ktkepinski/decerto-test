package com.decerto.app.rest;

import com.decerto.app.application.data.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/data")
@RequiredArgsConstructor
public class DataController {

    private final DataService dataService;

    @GetMapping("")
    public DataDTO getData(@RequestParam List<Long> dataSourcesIds, Long methodId) {
        return new DataDTO(dataService.getData(dataSourcesIds, methodId).asString());
    }
}
