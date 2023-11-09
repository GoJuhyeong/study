package study.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import study.project.dto.BoardDto;
import study.project.service.BoardService;

import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/post")
    public String write() {
        return "post-form";
    }

    @PostMapping("/post")
    public String save(BoardDto boardDto) {
        boardService.save(boardDto);
        return "redirect:/posts";
    }

    @GetMapping("/posts")
    public String list(Model model) {
        List<BoardDto> list = boardService.list();
        model.addAttribute("list", list);
        return "posts";
    }

    @GetMapping("/post/{id}")
    public String postView(@PathVariable long id, Model model) {
        BoardDto post = boardService.findById(id);
        model.addAttribute("post", post);
        return "post-view";
    }

    @GetMapping("/post/update/{id}")
    public String updateForm(@PathVariable long id, Model model) {
        BoardDto post = boardService.findById(id);
        model.addAttribute("post", post);
        return "post-update";
    }

    @PostMapping("/post/update")
    public String update(BoardDto boardDto) {
        boardService.update(boardDto);
        return "redirect:/posts";
    }

    @GetMapping("/post/delete/{id}")
    public String delete(@PathVariable long id) {
        boardService.delete(id);
        return "redirect:/posts";
    }

}
