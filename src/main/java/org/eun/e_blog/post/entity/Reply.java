package org.eun.e_blog.post.entity;

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
public class Reply extends BaseEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private Long userID;
    private Long postID;
    private String comment;
    private LocalDateTime deleted_at;

    @Builder
    public Reply( Long id, Long userID, Long postID, String comment ){
        this.id = id;
        this.userID = userID;
        this.postID = postID;
        this.comment = comment;
        this.deleted_at = null;
    }

    public void delete( LocalDateTime time ) { this.deleted_at = time; }
}
