package diary.diaryspring.controller;

import diary.diaryspring.domain.Member;
import diary.diaryspring.repository.MemoryMemberRepository;
import diary.diaryspring.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
@RequestMapping("/members")
public class MemberController {

    MemoryMemberRepository mr = new MemoryMemberRepository();
    MemberService ms = new MemberService(mr);

    @GetMapping("/join")
//    @GetMapping(value="/members/join")
    public String joinForm(Model model){
        return("members/join");
    }

    @PostMapping("/join")
    public String joinMember(@ModelAttribute Member member) {
        ms.join(member);
//        System.out.println(mr.findById(member.getId()).get().getName());
        return "redirect:/";
    }
}

