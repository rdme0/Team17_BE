package homeTry.chatting.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class MemberChatting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



}
