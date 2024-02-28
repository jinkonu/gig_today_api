package com.gigtoday.api.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class File {

    /* DB id */
    @Id @GeneratedValue
    @Column(name = "file_id")
    private Long id;

    /* Unrelated data */
    private String originalName;
    private String savedName;
    private String contentType;

    /* Related data */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gig_id")
    private Gig gig;

    /* Static data */
    private static final String filePath = "/Users/konu/code/API/src/main/java/com/gigtoday/files/";


    /* Domain logic */
    @SneakyThrows(IOException.class)
    public static File of(MultipartFile file) {
        String savedName = setSavedNameFrom(file.getOriginalFilename());
        file.transferTo(new java.io.File(filePath + savedName));

        return File.builder()
                .savedName(savedName)
                .originalName(file.getOriginalFilename())
                .contentType(file.getContentType())
                .build();
    }

    private static String setSavedNameFrom(String originalName) {
        return UUID.randomUUID() + "." + originalName;
    }
}
