package always.also.holiday.service;

import always.also.holiday.domain.member.Member;
import always.also.holiday.exception.DuplicateException;
import always.also.holiday.repository.MemberRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final EntityManager em;
    private final JPAQueryFactory query;
    private final BCryptPasswordEncoder passwordEncoder;
    public MemberService(MemberRepository memberRepository, EntityManager em, JPAQueryFactory query, BCryptPasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.em = em;
        this.query = query;
        this.passwordEncoder = passwordEncoder;
    }

    public Member joinMember(Member member) throws DuplicateException {

        /**
         * - 중복 재확인
         *
         * 1. 패스워드 인코딩
         * 2. 멤버에게 패스워드 넣기
         * 3. 멤버 넣기
         */

        Member idCheck = idDoubleCheck(member.getUsername());
        if (idCheck != null) {
            throw new DuplicateException("아이디가 중복입니다.");
        }

        Member mobileCheck = mobileDoubleCheck(member.getMobile());
        if (mobileCheck != null) {
            throw new DuplicateException("전화번호가 중복입니다");
        }

        Member nickDoubleCheck = nicknameDoubleCheck(member.getNickname());
        if (nickDoubleCheck != null) {
            throw new DuplicateException("닉네임이 중복입니다");
        }

        String encodePwd = pwdEncoding(member.getPassword());
        member.encodePassword(encodePwd);

        return memberRepository.save(member);
    }




    private Member nicknameDoubleCheck(String nickname) {
        return memberRepository.findByNickname(nickname);
    }
    private Member idDoubleCheck(String username) {
        return memberRepository.findByUsername(username);
    }
    private Member mobileDoubleCheck(String mobile) {
        return memberRepository.findByMobile(mobile);
    }
    private String pwdEncoding(String password) {
        return passwordEncoder.encode(password);
    }

}
