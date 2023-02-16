package diary.diaryspring.controller;

import diary.diaryspring.domain.Member;
import diary.diaryspring.repository.MemoryMemberRepository;
import diary.diaryspring.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
public class MemberController {

    MemoryMemberRepository mr = new MemoryMemberRepository();
    MemberService ms = new MemberService(mr);

    @GetMapping("/join")
    public String joinForm(Model model){
        model.addAttribute("member", new Member());
        model.addAttribute("move", false);
        return "members/join";
    }

    @PostMapping("/join")
    public String joinMember(Model model,
                             @RequestParam("button") String btn,
                             @RequestParam(value="dup", required = false) String dupMsg,
                             @ModelAttribute Member member) {
        if (btn.equals("중복확인")) {
            boolean isDuplicated = ms.checkSameId(member.getId());
            if (isDuplicated) { // 중복 시
                model.addAttribute("dup", "이미 존재하는 아이디입니다.");
            } else { // 통과 시
                model.addAttribute("pass", true);
            }
        } else { // 가입 버튼
            ms.join(member);
            System.out.println("가입 성공");
            model.addAttribute("move", true);
        }
        return "members/join";
    }

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("member", new Member());
        return "members/login";
    }

    @PostMapping("/login")
    public String loginMember(Model model, @ModelAttribute Member member) {
        String m = ms.login(member.getId(), member.getPw());
        model.addAttribute("message", m);
        return "members/login";

    }
}

