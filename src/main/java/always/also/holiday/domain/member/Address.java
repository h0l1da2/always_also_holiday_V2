package always.also.holiday.domain.member;

import lombok.Generated;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class Address {

    @Id @Generated
    private Long id;

    private String address;
    private String extraAddress;
    private String postcode;
    private String detail;
}
