package com.example.teamB.domain.hashtag.controller;

import com.example.teamB.domain.hashtag.dto.HashtagResponseDTO;
import com.example.teamB.domain.hashtag.service.query.HashtagQueryService;
import com.example.teamB.global.apiPayload.CustomResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "Hashtag API")
public class HashtagController {

    private final HashtagQueryService hashtagQueryService;

    @GetMapping("/recommendation")
    @Operation(summary = "오늘의 옷(해시태그) 추천 조회", description = "해시태그와 각 해시태그에 맞는 옷 사진을 반환합니다.")
    public CustomResponse<HashtagResponseDTO.DailyRecommendationListDTO> getRecommendation(
            @RequestParam(value = "maxTemperature") int maxTemperature,
            @RequestParam(value = "minTemperature") int minTemperature) {
        return CustomResponse.onSuccess(hashtagQueryService.getRecommendation(maxTemperature, minTemperature));
    }
}