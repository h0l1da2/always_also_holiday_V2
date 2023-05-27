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
}
