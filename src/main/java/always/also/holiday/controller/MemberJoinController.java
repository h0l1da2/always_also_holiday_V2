package always.also.holiday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberJoinController {

    @GetMapping("/join")
    public String joinForm() {
        return "member/joinForm";
    }
}
