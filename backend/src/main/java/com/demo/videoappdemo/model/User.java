package com.demo.videoappdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Document(value="User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String email;
    private Set<String> subscribeTo;
    private Set<String> subscribers;
    private List<String> browseHistory;
    private Set<String> likedVideo;
    private Set<String> dislikedVideo;

}
