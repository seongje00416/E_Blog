package org.eun.e_blog.user.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.eun.e_blog.util.entity.BaseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@FieldNameConstants
@NoArgsConstructor( access= AccessLevel.PROTECTED)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String nickName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate birthday;
    private LocalDateTime deletedAt;

    @Builder
    public User( Long id, String userName, String nickName, Gender gender, LocalDate birthday ) {
        this.id = id;
        this.userName = userName;
        this.nickName = nickName;
        this.gender = gender;
        this.birthday = birthday;
        this.deletedAt = null;
    }

    public void update( String name, String nickName, LocalDate birthday ) {
        this.userName = name;
        this.nickName = nickName;
        this.birthday = birthday;
    }

    public void delete( LocalDateTime time ){
        this.deletedAt = time;
    }
}
