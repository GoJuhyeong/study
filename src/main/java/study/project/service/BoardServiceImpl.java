package study.project.service;

import org.springframework.stereotype.Service;
import study.project.dto.BoardDto;
import study.project.repository.BoardRepository;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public void save(BoardDto boardDto) {
        boardRepository.saveBoard(boardDto);
    }

    @Override
    public List<BoardDto> list() {
        return boardRepository.boardList();
    }
}