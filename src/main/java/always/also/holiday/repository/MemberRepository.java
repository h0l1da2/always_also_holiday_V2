package always.also.holiday.repository;

import always.also.holiday.domain.member.Member;
import org.springframework.data.repository.Repository;

public interface MemberRepository extends Repository<Member, Long> {
    Member insertMember(Member member);
    Member findByUsername(String username);
    Member findByMobile(String email);
    Member findByNickname(String nickname);
}
