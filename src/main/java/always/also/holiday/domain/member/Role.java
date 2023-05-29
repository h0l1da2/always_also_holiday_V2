package always.also.holiday.domain.member;

import lombok.Generated;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Getter
@Entity
public class Role {

    @Id @Generated
    private Long id;
    @Enumerated(EnumType.STRING)
    private Name name;
    public Role() {}
    public Role(Name name) {
        this.name = name;
    }


}
