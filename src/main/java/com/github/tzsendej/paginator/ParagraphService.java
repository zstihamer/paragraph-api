package com.github.tzsendej.paginator;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ParagraphService {
    private static final String template = "<div><p>Paragraph %s! lorem ipsum</p></div>";
    private final AtomicLong counter = new AtomicLong();
    private final int total = 1000;


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
        for (int i = skip; i <= (skip + take - 1); i++) {
            data.add(generateRandomData(i + 1));
        }
        return new DataResult(this.total, data);
    }

    public String generateRandomData(int counter) {
        int leftLimit = 48;
        int rightLimit = 122;
        Random random = new Random();
        int max = 2000;
        int min = 100;
        int targetStringLength = random.nextInt(max + 1 - min) + min;

        String ret = "<div><h6>Paragraph " + counter + "!</h6><br><div><p>" + random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString()
                + "</p></div></div>";

        // System.out.println(ret);
        return StringEscapeUtils.escapeHtml4(ret);

    }
}

