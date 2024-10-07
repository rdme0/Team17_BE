package homeTry.chatting.service;

import homeTry.chatting.dto.ChatMessageDTO;
import homeTry.chatting.repository.ChattingRepository;
import homeTry.member.dto.MemberDTO;
import homeTry.member.model.entity.Member;
import homeTry.member.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class ChattingService {

    private final MemberService memberService;

    private final ChattingRepository chattingRepository;

    public ChattingService(MemberService memberService, ChattingRepository chattingRepository) {
        this.memberService = memberService;
        this.chattingRepository = chattingRepository;
    }

    @Transactional
    public void saveChatting(Long teamId, ChatMessageDTO chatMessageDTO, MemberDTO memberDTO) {
        Member member = memberService.getMemberEntity(memberDTO.id());

    }


}
