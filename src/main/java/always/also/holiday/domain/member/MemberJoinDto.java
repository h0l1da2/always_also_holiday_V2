package always.also.holiday.domain.member;

import lombok.Data;

@Data
public class MemberJoinDto {

    private String username;
    private String password;
    private String name;
    private String nickname;
    private String address;
    private String postcode;
    private String detail;
    private String extraAddress;
    private String email;
    private String mobile;
    private String code;
}
