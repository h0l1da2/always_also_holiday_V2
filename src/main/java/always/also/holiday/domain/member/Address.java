package always.also.holiday.domain.member;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class Address {

    @Id @GeneratedValue
    private Long id;

    private String address;
    private String extraAddress;
    private String postcode;
    private String detail;

    public Address() {}

    public Address(MemberJoinDto memberJoinDto) {
        this.address = memberJoinDto.getAddress();
        this.extraAddress = memberJoinDto.getExtraAddress();
        this.postcode = memberJoinDto.getPostcode();
        this.detail = memberJoinDto.getDetail();
    }
}
