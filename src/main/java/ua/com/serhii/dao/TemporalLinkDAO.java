package ua.com.serhii.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ua.com.serhii.entity.TemporalLink;
import ua.com.serhii.entity.enumeration.TemporalLinkType;

import java.time.LocalDateTime;

public interface TemporalLinkDAO extends JpaRepository<TemporalLink, Long> {

    TemporalLink findByTokenAndTypeAndActiveIsTrueAndExpiryDateIsAfter(String token, TemporalLinkType temporalLinkType,
                                                                       LocalDateTime expiryDate);

    @Transactional
    @Modifying
    @Query(value = "update TemporalLink l set l.active = :active where l.token = :token")
    void updateActiveTemporalLinkByToken(@Param("token") String token, @Param("active") Boolean active);

}
