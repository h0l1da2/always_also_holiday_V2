package always.also.holiday.domain.member;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Getter
@Entity
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private String name;
    private String nickname;
    @Email
    private String email;
    private String mobile;

    private Date remove;
    private Date stop;
    private Date lastLogin;
    private Date created;
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
        this.created = new Date();
        this.pwdChange = new Date();
        this.role = new Role(Name.ROLE_USER);
        this.address = new Address(memberJoinDto);
    }

    public void encodePassword(String encodePwd) {
        this.password = encodePwd;
    }
}
