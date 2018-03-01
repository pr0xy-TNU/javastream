package less5service;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/content")
    public Content greeting(@RequestParam(value = "name", defaultValue = "World") String name,
        @RequestParam(value = "age", defaultValue = "24") Integer age) {
        return new Content(counter.incrementAndGet(), String.format(template, name), age);
    }
}
