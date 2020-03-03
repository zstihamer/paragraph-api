package com.github.tzsendej.paginator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@Slf4j
public class ParagraphService {
    private static final String template = "<p>Paragraph %s! lorem ipsum</p>";
    private final AtomicLong counter = new AtomicLong();
    private final int total = 500;


    @GetMapping("/paragraphs")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public DataResult getParagraphs(@RequestParam(value = "_t", required = false) Integer take, @RequestParam(value = "_s", required = false) Integer skip) {
        List<String> data = new ArrayList<>();
        if (skip == null) {
            skip = 0;
        }
        if (take == null) {
            take = 30;
        }
        for (int i = skip; i <= (skip + take -1); i++) {
            data.add(String.format(template, i +1));
        }
        return new DataResult(this.total, data);
    }
}

