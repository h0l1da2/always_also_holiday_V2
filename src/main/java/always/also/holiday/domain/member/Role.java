package always.also.holiday.domain.member;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Role {

    @Id @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private Name name;
    public Role() {}
    public Role(Name name) {
        this.name = name;
    }


}
