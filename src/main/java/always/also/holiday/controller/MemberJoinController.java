package always.also.holiday.controller;

import always.also.holiday.domain.member.Member;
import always.also.holiday.domain.member.MemberJoinDto;
import always.also.holiday.exception.DuplicateException;
import always.also.holiday.service.MemberService;
import always.also.holiday.service.WebService;
import com.google.gson.JsonObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
public class MemberJoinController {

    private final WebService webService;
    private final MemberService memberService;

    public MemberJoinController(WebService webService, MemberService memberService) {
        this.webService = webService;
        this.memberService = memberService;
    }

    @GetMapping("/join")
    public String joinForm(Model model) {
        model.addAttribute("member", new MemberJoinDto());
        return "member/joinForm";
    }

    // TODO 회원가입 로직 작성
    @ResponseBody
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody MemberJoinDto memberJoinDto) {
        JsonObject jsonObject = new JsonObject();

        try {

            memberService.joinMember(new Member(memberJoinDto));
            jsonObject.addProperty("body", "JOIN_OK");

        } catch (DuplicateException e) {
            e.printStackTrace();

            if (e.getMessage().contains("아이디")) {
                jsonObject.addProperty("error","ID_DUPL");
            }
            if (e.getMessage().contains("전화번호")) {
                jsonObject.addProperty("error","MOBILE_DUPL");
            }
            if (e.getMessage().contains("닉네임")) {
                jsonObject.addProperty("error","NICK_DUPL");
            }
            return webService.badResponseEntity(jsonObject);
        }

        return webService.okResponse(jsonObject);
    }
}
