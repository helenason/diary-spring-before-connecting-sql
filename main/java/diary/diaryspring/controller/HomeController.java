package diary.diaryspring.controller;

import diary.diaryspring.domain.Member;
import diary.diaryspring.repository.MemoryMemberRepository;
import diary.diaryspring.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return("home");
    }
}
