package org.eun.e_blog.post.entity;

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
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@FieldNameConstants
public class PostFile extends BaseEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "file_id" )
    private Long id;
    private int fileIndex;
    private String fileURL;
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "post_id")
    private Post post;
    @Enumerated( EnumType.STRING )
    private FileType fileType;
    private LocalDateTime deletedAt;

    @Builder
    public PostFile( Long id, int index, String fileURL, Post post, FileType fileType ){
        this.id = id;
        this.fileIndex = index;
        this.fileURL = fileURL;
        this.post = post;
        this.fileType = fileType;
        this.deletedAt = null;
    }

    public void delete( LocalDateTime time ) { this.deletedAt = time; }
}
