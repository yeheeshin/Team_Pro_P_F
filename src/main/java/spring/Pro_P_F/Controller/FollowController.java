package spring.Pro_P_F.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.Pro_P_F.domain.Company;
import spring.Pro_P_F.domain.Member;
import spring.Pro_P_F.repository.CompanyMemRepository;
import spring.Pro_P_F.repository.MemberRepository;
import spring.Pro_P_F.service.FollowService;

import javax.servlet.http.HttpSession;

@Controller
public class FollowController {
    @Autowired
    private FollowService followService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CompanyMemRepository companyMemRepository;

    @GetMapping("/follow")
    public String followCompany(@RequestParam("id") Long companyId, HttpSession session) {
        // 현재 로그인한 사용자 정보 가져오기
        String mId = (String) session.getAttribute("m_id");
        Member member = memberRepository.findByMid(mId);

        // 팔로우할 기업 회원 정보 가져오기
        Company company = companyMemRepository.findById(companyId).orElse(null);

        // 팔로우 기능 수행
        if (member != null && company != null) {
            followService.follow(member, company);
        }

        return "redirect:/company_ch"; // 팔로우 후 리다이렉트할 경로 설정
    }
}