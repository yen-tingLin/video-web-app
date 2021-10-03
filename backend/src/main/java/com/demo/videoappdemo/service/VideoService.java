package com.demo.videoappdemo.service;

import com.demo.videoappdemo.model.Video;
import com.demo.videoappdemo.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final AwsService awsService;
    private final VideoRepository videoRepository;

    public void uploadVideo(MultipartFile file) {
        String videoUrl = awsService.uploadFile(file);
        Video video = new Video();
        video.setVideoUrl(videoUrl);

        videoRepository.save(video);
    }
}
