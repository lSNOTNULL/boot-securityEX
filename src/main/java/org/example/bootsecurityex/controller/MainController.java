package org.example.bootsecurityex.controller;

import org.example.bootsecurityex.model.domain.Memo;
import org.example.bootsecurityex.model.domain.MemoForm;
import org.example.bootsecurityex.model.mapper.MemoMapper;
import org.example.bootsecurityex.service.MemoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    private final MemoService memoService;

    public MainController(MemoMapper memoMapper, MemoService memoService) {
        this.memoService = memoService;
    }



    @GetMapping
    public String index(Model model) {
        model.addAttribute("memoList", memoService.findAll());
        return "index";
    }

    @PostMapping
    public String save(MemoForm form) throws Exception {
        Memo memo = new Memo(0L,form.getText(),"");
        memoService.create(memo);
        return "redirect:/";
    }
}
