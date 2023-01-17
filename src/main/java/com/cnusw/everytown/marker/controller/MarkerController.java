package marker.controller;

import marker.dto.*;
import marker.dto.MarkerResponse.LossMarkerResponse;
import marker.dto.MarkerResponse.PhotoMarkerResponse;
import marker.dto.MarkerResponse.TalkMarkerResponse;
import marker.service.MarkerPointExistsException;
import marker.service.MarkerService;
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
    @PostMapping("/loss-marker/create")
    public ResponseEntity createLossMarker(@RequestBody LossMarkerCreatedRequest lossDto){
        try {
            markerService.makeLossMarker(lossDto);
        } catch (MarkerPointExistsException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    // Talk 마커 생성
    @PostMapping("/talk-marker/create")
    public ResponseEntity createTalkMarker(@RequestBody TalkMarkerCreatedRequest talkDto){
        try {
            markerService.makeTalkMarker(talkDto);
        } catch (MarkerPointExistsException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    // Photo 마커 생성
    @PostMapping("/photo-marker/create")
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
    @GetMapping("/markers")
    @ResponseBody
    public ResponseEntity<List<MarkerDto>> readAllMarkers(){
        List<MarkerDto> markerDtos = markerService.readAllMarkers();
        return ResponseEntity.ok().body(markerDtos);
    }

    // 모든 talk 마커 조회
    @GetMapping("/markers/talk")
    @ResponseBody
    public ResponseEntity<List<MarkerDto>> readTalkMarkers(){
        List<MarkerDto> markerDtos = markerService.readAllTalkMarkers();
        return ResponseEntity.ok().body(markerDtos);
    }

    // 모든 loss 마커 조회
    @GetMapping("/markers/loss")
    @ResponseBody
    public ResponseEntity<List<MarkerDto>> readLossMarkers(){
        List<MarkerDto> markerDtos = markerService.readAllLossMarkers();
        return ResponseEntity.ok().body(markerDtos);
    }

    // 모든 photo 마커 조회
    @GetMapping("/markers/photo")
    @ResponseBody
    public ResponseEntity<List<MarkerDto>> readPhotoMarkers(){
        List<MarkerDto> markerDtos = markerService.readAllPhotoMarkers();
        return ResponseEntity.ok().body(markerDtos);
    }


    // 주어진 id, type의 마커 내용물 가져오기
    @PostMapping("/get-marker")
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
