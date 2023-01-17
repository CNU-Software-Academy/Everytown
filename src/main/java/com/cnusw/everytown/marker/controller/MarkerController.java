package com.cnusw.everytown.marker.controller;


import com.cnusw.everytown.marker.dto.*;
import com.cnusw.everytown.marker.dto.MarkerResponse.LossMarkerResponse;
import com.cnusw.everytown.marker.dto.MarkerResponse.PhotoMarkerResponse;
import com.cnusw.everytown.marker.dto.MarkerResponse.TalkMarkerResponse;
import com.cnusw.everytown.marker.service.MarkerPointExistsException;
import com.cnusw.everytown.marker.service.MarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarkerController {

    @Autowired
    private MarkerService markerService;

    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 1. Create Markers ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    // Loss 마커 생성
    @PostMapping("/marker/new/loss")
    public ResponseEntity createLossMarker(@RequestBody LossMarkerCreatedRequest lossDto){
        try {
            markerService.makeLossMarker(lossDto);
        } catch (MarkerPointExistsException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    // Talk 마커 생성
    @PostMapping("/marker/new/talk")
    public ResponseEntity createTalkMarker(@RequestBody TalkMarkerCreatedRequest talkDto){
        try {
            markerService.makeTalkMarker(talkDto);
        } catch (MarkerPointExistsException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    // Photo 마커 생성
    @PostMapping("/marker/new/photo")
    public ResponseEntity createPhotoMarker(@RequestBody PhotoMarkerCreatedRequest photoDto){
        try {
            markerService.makePhotoMarker(photoDto);
        } catch (MarkerPointExistsException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }


    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 2. Read Markers ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    // 모든 마커 조회
    @GetMapping("/marker/all")
    @ResponseBody
    public ResponseEntity<List<MarkerDto>> readAllMarkers(){
        List<MarkerDto> markerDtos = markerService.readAllMarkers();
        return ResponseEntity.ok().body(markerDtos);
    }

    // 모든 talk 마커 조회
    @GetMapping("/marker/all/talk")
    @ResponseBody
    public ResponseEntity<List<MarkerDto>> readTalkMarkers(){
        List<MarkerDto> markerDtos = markerService.readAllTalkMarkers();
        return ResponseEntity.ok().body(markerDtos);
    }

    // 모든 loss 마커 조회
    @GetMapping("/marker/all/loss")
    @ResponseBody
    public ResponseEntity<List<MarkerDto>> readLossMarkers(){
        List<MarkerDto> markerDtos = markerService.readAllLossMarkers();
        return ResponseEntity.ok().body(markerDtos);
    }

    // 모든 photo 마커 조회
    @GetMapping("/marker/all/photo")
    @ResponseBody
    public ResponseEntity<List<MarkerDto>> readPhotoMarkers(){
        List<MarkerDto> markerDtos = markerService.readAllPhotoMarkers();
        return ResponseEntity.ok().body(markerDtos);
    }


    // 주어진 id, type의 마커 내용물 가져오기
    @PostMapping("/marker/read")
    @ResponseBody
    public ResponseEntity getThisMarker(@RequestBody MarkerIdDto dto){
        String type = dto.getType();
        switch(type){
            case "Loss":
                LossMarkerResponse lossResponse = markerService.getLossMarkerById(dto.getId());
                return ResponseEntity.ok(lossResponse);
            case "Talk":
                TalkMarkerResponse talkResponse = markerService.getTalkMarkerById(dto.getId());
                return ResponseEntity.ok(talkResponse);
            case "Photo":
                PhotoMarkerResponse photoResponse = markerService.getPhotoMarkerById(dto.getId());
                return ResponseEntity.ok(photoResponse);
        }
        return ResponseEntity.badRequest().build();
    }
}
