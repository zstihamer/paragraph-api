package com.github.tzsendej.paginator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@Slf4j
public class ParagraphService {
    private static final String template = "<p>Paragraph %s! lorem ipsum</p>";
    private final AtomicLong counter = new AtomicLong();
    private final int total = 500;


    @GetMapping("/paragraph")
    @ResponseBody
    public DataResult greeting(@RequestParam(value = "_t", required = false) Integer take, @RequestParam(value = "_s", required = false) Integer skip) {
        List<String> data = new ArrayList<>();
        if (skip == null) {
            skip = 0;
        }
        if (take == null) {
            take = 30;
        }
        for (int i = skip; i <= (skip + take); i++) {
            data.add(String.format(template, i));
        }
        return new DataResult(this.total, data);
    }
}
