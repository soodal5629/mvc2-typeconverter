package hello.typeconverter.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
@Slf4j
public class FormatterController {
    @GetMapping("/formatter/edit")
    public String formatterForm(Model model) {
        Form form = new Form();
        form.setNumber(10000);
        form.setLocalDateTime(LocalDateTime.now());
        model.addAttribute("form", form);
        return "/formatter-form";
    }

    // 사실 ModelAttribute Form 데이터에
    // 문자 "10,000" 와 문자 "2023-02-23 21:37:55" 가 들어오지만
    // 컨트롤러 호출직전에 포매터가 Form 객체로 convert 해줘서 들어옴
    // 결국 "10,000" --> 10000, "2023-02-23 21:37:55" --> LocalDateTime 객체로 변형됨
    @PostMapping("/formatter/edit")
    public String formatterEdit(@ModelAttribute Form form) {
        return "/formatter-view";
    }

    @Data
    static class Form {
        // 두 어노테이션이 있으면 스프링에서 기본으로 제공하는 포매터가 적용됨
        @NumberFormat(pattern = "###,###")
        private Integer number;
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime localDateTime;
    }
}
