package ua.com.serhii.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.serhii.entity.enumeration.TemporalLinkType;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "temporal_links")
public class TemporalLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 200)
    @Column(length = 200, unique = true, nullable = false)
    private String token;

    @Enumerated(EnumType.STRING)
    private TemporalLinkType type;

    @Column(nullable = false)
    private Boolean active = true;

    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users")
    private User users;

    public TemporalLink(String token, TemporalLinkType type, LocalDateTime date, User users) {
        this.token = token;
        this.type = type;
        this.expiryDate = date;
        this.users = users;
    }
}
