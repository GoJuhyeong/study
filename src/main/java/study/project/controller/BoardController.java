package study.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import study.project.dto.BoardDto;
import study.project.service.BoardService;

import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/write")
    public String write() {
        return "write";
    }

    @PostMapping("/write")
    public void save(BoardDto boardDto) {
        boardService.save(boardDto);
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<BoardDto> list = boardService.list();
        model.addAttribute("list", list);
        return "list";
    }
}
