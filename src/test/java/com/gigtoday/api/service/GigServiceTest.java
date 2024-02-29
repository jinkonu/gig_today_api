//package com.gigtoday.api.service;
//
//import com.gigtoday.api.domain.Artist;
//import com.gigtoday.api.domain.Venue;
//import com.gigtoday.api.repository.ArtistRepository;
//import com.gigtoday.api.repository.VenueRepository;
//import com.gigtoday.api.util.dto.GigJoinDto;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Transactional
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//class GigServiceTest {
//
//    @Autowired
//    VenueRepository venueRepository;
//    @Autowired
//    ArtistRepository artistRepository;
//    @Autowired
//    GigService gigService;
//
//
//    @BeforeEach
//    void init() {
//        venueRepository.save(Venue.builder()
//                .name("club ff")
//                .profile("지상 최고의 인디 공연장")
//                .build()
//        );
//
//        artistRepository.save(Artist.builder()
//                .name("초록불꽃소년단")
//                .profile("지상 최고의 펑크 밴드")
//                .build()
//        );
//    }
//
//    @Test
//    void join() throws Exception {
//        // given
//        List<MultipartFile> files = new ArrayList<>();
//        GigJoinDto.builder()
//                .name("카쉬라")
//                        .date("2024-02-28")
//                .startTime("18:00")
//                .endTime("20")
//                                .
//
//        gigService.join(files, )
//
//        // when
//
//        // then
//
//    }
//}
//
//{
//        "name":"카슈라",
//        "image":"Woodstock_poster.png",
//        "date":"2024-02-28",
//        "startTime":"18:00",
//        "endTime":"21:00",
//        "ticketPrice":"30000",
//        "notice":"청소년 관람 불가",
//        "venueId":1,
//        "artistIds": [1]
//        }