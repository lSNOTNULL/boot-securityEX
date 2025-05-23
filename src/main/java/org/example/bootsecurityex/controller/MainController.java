package org.example.bootsecurityex.controller;

import org.example.bootsecurityex.model.domain.Memo;
import org.example.bootsecurityex.model.domain.MemoForm;
import org.example.bootsecurityex.model.mapper.MemoMapper;
import org.example.bootsecurityex.service.MemoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("memoForm", new MemoForm());
        return "add";
    }

    @PostMapping("/add")
    public String save(MemoForm form) throws Exception {
//        Memo memo = new Memo(0L,form.getText(),"");
        Memo memo = Memo.fromText(form.getText());
        memoService.create(memo);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        String msg = "%d를 정상적으로 삭제하였습니다.".formatted(id);
        redirectAttributes.addFlashAttribute("msg", msg);
        memoService.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/delete-all")
    public String deleteAll(RedirectAttributes redirectAttributes) throws Exception {
        memoService.deleteAll();
        redirectAttributes.addFlashAttribute("msg","전체 삭제");
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Memo memo = memoService.findById(id);
        model.addAttribute("memo", memo);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @RequestParam String text,RedirectAttributes redirectAttributes) {
        Memo oldMemo = memoService.findById(id);
        Memo newMemo = new Memo(oldMemo.id(), text, oldMemo.createdAt());
        memoService.update(newMemo);
        redirectAttributes.addFlashAttribute("msg", "정상적으로 수정됨");
        return "redirect:/";
    }
}
