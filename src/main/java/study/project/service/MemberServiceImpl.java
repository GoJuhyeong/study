package study.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.project.dto.MemberDto;
import study.project.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void memberSave(MemberDto memberDto) {
        memberRepository.memberSave(memberDto);
    }

    @Override
    public MemberDto login(MemberDto memberDto) {
        /*
        1. 회원이 입력한 이메일로 DB에서 조회를 함
        2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
         */
        MemberDto byMemberEmail = memberRepository.findByMemberEmail(memberDto);
        if (byMemberEmail.getMemberEmail() != null) {
            //조회 결과가 있다(해당 이메일을 가진 회원 정보가 있다)
            if (byMemberEmail.getMemberEmail().equals(memberDto.getMemberEmail())) {
                //비밀번호 일치
                return byMemberEmail;
            } else {
                //비밀번호 불일치(로그인 실패)
                return null;
            }
        } else {
            //조회 결과가 없다(해당 이메일을 가진 회원이 없다)
            return null;
        }
    }
}
