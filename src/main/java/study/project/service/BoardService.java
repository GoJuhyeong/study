package study.project.service;

import study.project.dto.BoardDto;

import java.util.List;

public interface BoardService {
    void save(BoardDto boardDto);
    List<BoardDto> list();
    BoardDto findById(long id);
}
