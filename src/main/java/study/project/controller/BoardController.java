package study.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String save(BoardDto boardDto) {
        boardService.save(boardDto);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<BoardDto> list = boardService.list();
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/post/view/{id}")
    public String postView(@PathVariable long id, Model model) {
        BoardDto post = boardService.findById(id);
        model.addAttribute("post", post);
        return "view";
    }
}
