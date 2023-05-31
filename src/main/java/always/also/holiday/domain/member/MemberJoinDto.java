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

    public MemberJoinDto() {
    }

    public MemberJoinDto(String username, String password, String name, String nickname, String address, String postcode, String detail, String extraAddress, String email, String mobile, String code) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.address = address;
        this.postcode = postcode;
        this.detail = detail;
        this.extraAddress = extraAddress;
        this.email = email;
        this.mobile = mobile;
        this.code = code;
    }
}
