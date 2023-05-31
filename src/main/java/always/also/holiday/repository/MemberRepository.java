package always.also.holiday.repository;

import always.also.holiday.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member save(Member member);
    Member findByUsername(String username);
    Member findByMobile(String email);
    Member findByNickname(String nickname);
}
