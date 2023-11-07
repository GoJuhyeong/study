package study.project.repository;

import org.apache.ibatis.annotations.Mapper;
import study.project.dto.MemberDto;

@Mapper
public interface MemberRepository {
    void memberSave(MemberDto memberDto);

    MemberDto findByMemberEmail(MemberDto memberDto);
}
