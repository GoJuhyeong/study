package study.project.repository;

import org.apache.ibatis.annotations.Mapper;
import study.project.dto.BoardDto;

@Mapper
public interface BoardRepository {
    void saveBoard(BoardDto boardDto);
}
