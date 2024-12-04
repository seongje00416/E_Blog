package org.eun.e_blog.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.eun.e_blog.util.entity.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@FieldNameConstants
@NoArgsConstructor
public class Account extends BaseEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String email;
    private String password;
    private Long userID;
    private LocalDateTime deletedAt;

    @Builder
    public Account( Long id, String email, String password, Long userID ){
        this.id = id;
        this.email = email;
        this.password = password;
        this.userID = userID;
        this.deletedAt = null;
    }

    public void delete( LocalDateTime time ) { this.deletedAt = time; }
}
