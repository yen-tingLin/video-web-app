package com.demo.videoappdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Document(value="Video")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {
    @Id
    private String id;

    private String title;
    private String description;
    private String userId;
    private Integer likes;
    private Integer dislikes;
    private Integer viewCount;
    private String videoUrl;
    private String thumbnailUrl;
    private VideoStatus status;
    private Set<String> tags;
    private List<Comment> comments;
}
