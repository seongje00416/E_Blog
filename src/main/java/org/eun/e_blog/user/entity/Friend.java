package org.eun.e_blog.user.entity;

import jakarta.persistence.*;
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
public class Friend extends BaseEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private Long userID;
    private Long friendID;
    @Enumerated( EnumType.STRING )
    private FriendAssign friendAssign;
    private LocalDateTime deleted_at;

    @Builder
    public Friend( Long id, Long userID, Long friendID, FriendAssign friendAssign ) {
        this.id = id;
        this.userID = userID;
        this.friendID = friendID;
        this.friendAssign = friendAssign;
        this.deleted_at = null;
    }

    public void delete( LocalDateTime time ) { this.deleted_at = time; }
    public void update( FriendAssign friendAssign ) { this.friendAssign = friendAssign; }
}
