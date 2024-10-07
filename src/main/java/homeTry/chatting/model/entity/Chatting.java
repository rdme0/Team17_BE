package homeTry.chatting.model.entity;

import homeTry.team.model.entity.Team;
import homeTry.team.model.entity.TeamMember;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Chatting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Team team;

    @Column(nullable = false)
    private String message;

    @OneToOne
    private TeamMember teamMember;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createAt;

    protected Chatting() { }

    public Chatting(Team team, String message) {
        this.team = team;
        this.message = message;
    }

    public Long getId() { return id; }
    public Team getTeam() { return team; }
    public String getMessage() { return message; }
    public LocalDateTime getCreateAt() { return createAt; }
}
