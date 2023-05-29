package always.also.holiday.domain.member;

import lombok.Generated;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Getter
@Entity
public class Member {

    @Id @Generated
    private Long id;

    private String username;
    private String password;
    private String name;
    private String nickname;
    @Email
    private String email;
    private String mobile;

    private Date delete;
    private Date stop;
    private Date lastLogin;
    private Date join;
    private Date pwdChange;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public Member() {}

    // MemberController 일반 유저 가입시
    public Member(MemberJoinDto memberJoinDto) {
        this.username = memberJoinDto.getUsername();
        this.password = memberJoinDto.getPassword();
        this.name = memberJoinDto.getName();
        this.nickname = memberJoinDto.getNickname();
        this.email = memberJoinDto.getEmail();
        this.mobile = memberJoinDto.getMobile();
        this.join = new Date();
        this.pwdChange = new Date();
        this.role = new Role(Name.ROLE_USER);
        this.address = new Address(memberJoinDto);
    }

    public void encodePassword(String encodePwd) {
        this.password = encodePwd;
    }
}
