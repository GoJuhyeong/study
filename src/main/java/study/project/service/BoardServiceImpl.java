package study.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.project.dto.BoardDto;
import study.project.repository.BoardRepository;

import java.util.Date;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public void save(BoardDto boardDto) {
        boardDto.setCreated_at(new Date());
        System.out.println(boardDto.getCreated_at());
        boardRepository.saveBoard(boardDto);
    }

    @Override
    public List<BoardDto> list() {
        return boardRepository.boardList();
    }
}
