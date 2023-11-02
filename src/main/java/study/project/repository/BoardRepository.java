package study.project.repository;

import org.apache.ibatis.annotations.Mapper;
import study.project.dto.BoardDto;

import java.util.List;

@Mapper
public interface BoardRepository {
    void saveBoard(BoardDto boardDto);
    List<BoardDto> boardList();
}
