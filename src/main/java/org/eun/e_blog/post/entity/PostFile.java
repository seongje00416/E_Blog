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
@NoArgsConstructor
@FieldNameConstants
public class PostFile extends BaseEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private int index;
    private String fileURL;
    private Long postID;
    private FileType fileType;
    private LocalDateTime deleted_at;

    @Builder
    public PostFile( Long id, int index, String fileURL, Long postID, FileType fileType ){
        this.id = id;
        this.index = index;
        this.fileURL = fileURL;
        this.postID = postID;
        this.fileType = fileType;
        this.deleted_at = null;
    }

    public void delete( LocalDateTime time ) { this.deleted_at = time; }
}
