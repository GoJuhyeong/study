package study.project.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import study.project.dto.BoardDto;

import java.util.List;

@Mapper
public interface BoardRepository {
    void saveBoard(BoardDto boardDto);

    List<BoardDto> boardList();

    BoardDto findById(long id);

    void update(BoardDto boardDto);

    void delete(long id);
}
