package homeTry.chatting.controller;

import homeTry.annotation.LoginMember;
import homeTry.chatting.dto.ChatMessageDTO;
import homeTry.chatting.service.ChattingService;
import homeTry.member.dto.MemberDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChattingController {
    private final SimpMessageSendingOperations template;

    private final ChattingService chattingService;

    public ChattingController(SimpMessageSendingOperations template,
            ChattingService chattingService) {
        this.template = template;
        this.chattingService = chattingService;
    }


    @GetMapping("/chat/{id}")
    public ResponseEntity<List<ChatMessageDTO>> getChatMessages(@PathVariable Long id){
        //임시로 리스트 형식으로 구현, 실제론 DB 접근 필요
        ChatMessageDTO test = new ChatMessageDTO(1L, "test", "test");
        return ResponseEntity.ok().body(List.of(test));
    }

    //메시지 송신 및 수신, /pub 을 생략할 수 있음. 클라이언트 단에선 /pub/message로 요청
    @MessageMapping("/pub/{teamId}/message")
    public ResponseEntity<Void> receiveMessage(@DestinationVariable Long teamId,
            @RequestBody ChatMessageDTO chatMessageDTO, @LoginMember MemberDTO memberDTO) {
        //db에 저장
        chattingService.saveChatting(teamId, chatMessageDTO, memberDTO);
        // 메시지를 해당 채팅방 구독자들에게 전송
        template.convertAndSend("/sub/chatroom/%d".formatted(teamId), chatMessageDTO);
        return ResponseEntity.ok().build();
    }

}
