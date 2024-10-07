package homeTry.chatting.repository;

import homeTry.chatting.model.entity.Chatting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChattingRepository extends JpaRepository<Chatting, Long> {

}
