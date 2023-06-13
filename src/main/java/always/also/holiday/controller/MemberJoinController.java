package always.also.holiday.controller;

import always.also.holiday.domain.Mail;
import always.also.holiday.domain.member.Member;
import always.also.holiday.domain.member.MemberJoinDto;
import always.also.holiday.exception.DuplicateException;
import always.also.holiday.service.EmailService;
import always.also.holiday.service.MemberService;
import always.also.holiday.service.WebService;
import com.google.gson.JsonObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@Controller
@RequestMapping("/member")
public class MemberJoinController {

    private final WebService webService;
    private final MemberService memberService;
    private final EmailService emailService;
    private String randomCode;

    public MemberJoinController(WebService webService, MemberService memberService, EmailService emailService) {
        this.webService = webService;
        this.memberService = memberService;
        this.emailService = emailService;
    }

    @GetMapping("/join")
    public String joinForm(Model model) {
        model.addAttribute("member", new MemberJoinDto());
        return "member/joinForm";
    }

    // TODO Email Code 전송
    @ResponseBody
    @PostMapping("/emailSend")
    public ResponseEntity<String> emailSend(@RequestParam String email) {
        JsonObject jsonObject = new JsonObject();
        try {
            randomCode = emailService.joinCodeSend(Mail.JOIN, email);
        } catch (MessagingException e) {
            e.printStackTrace();
            jsonObject.addProperty("error", "SEND_ERROR");
            webService.badResponseEntity(jsonObject);
        }
        jsonObject.addProperty("body", "SEND_OK");
        return webService.okResponse(jsonObject);
    }

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
