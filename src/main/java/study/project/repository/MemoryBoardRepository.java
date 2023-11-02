package study.project.repository;

import org.springframework.stereotype.Repository;
import study.project.dto.BoardDto;

@Repository
public class MemoryBoardRepository implements BoardRepository{
    @Override
    public void saveBoard(BoardDto boardDto) {

    }
}
