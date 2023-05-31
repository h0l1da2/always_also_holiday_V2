package always.also.holiday.repository;

import always.also.holiday.domain.member.Member;
import always.also.holiday.domain.member.MemberJoinDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
//인메모리 데이터베이스를 사용하도록 지정
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberRepositoryTest {

    @Autowired
    public MemberRepository memberRepository;

    @BeforeEach
    void saveMember() {
        memberRepository.save(getMember());
    }

    @Test
    void save() {

        Member save = memberRepository.save(getMember());

        assertThat(save).isNotNull();
        assertThat(save.getId()).isNotNull();
        assertThat(save.getUsername()).isEqualTo("username");

    }

    @Test
    void findByUsername() {
        Member byUsername = memberRepository.findByUsername("username");

        assertThat(byUsername).isNotNull();
        assertThat(byUsername.getId()).isNotNull();
        assertThat(byUsername.getUsername()).isEqualTo("username");
    }

    @Test
    void findByMobile() {
        Member byMobile = memberRepository.findByMobile("mobile");

        assertThat(byMobile).isNotNull();
        assertThat(byMobile.getId()).isNotNull();
        assertThat(byMobile.getMobile()).isEqualTo("mobile");
    }

    @Test
    void findByNickname() {
        Member byNickname = memberRepository.findByNickname("nickname");

        assertThat(byNickname).isNotNull();
        assertThat(byNickname.getId()).isNotNull();
        assertThat(byNickname.getNickname()).isEqualTo("nickname");
    }

    private Member getMember() {
        return new Member(new MemberJoinDto(
                "username","password","name","nickname","address","postcode","detail","extra","email@email.com","mobile","code"
        ));
    }
}