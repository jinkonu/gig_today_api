package com.gigtoday.api.service;

import com.gigtoday.api.domain.File;
import com.gigtoday.api.domain.Gig;
import com.gigtoday.api.repository.FileRepository;
import com.gigtoday.api.repository.GigRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class FileService {

    private final FileRepository fileRepository;
    private final GigRepository gigRepository;

    public byte[] findGigImages(Long gigId) {
//        List<File> files = fileRepository.findAllByGig_Id(gigId);
//
//        return files.stream()
//                .map(File::toByteArray)
//                .toList();

        return fileRepository.findAllByGig_Id(gigId).get(0)
                .toByteArray();
    }
}
