package marker.service;

import com.example.demo.dto.PointDto;
import marker.dto.LossMarkerCreatedRequest;
import marker.dto.MarkerDto;
import marker.dto.MarkerResponse.LossMarkerResponse;
import marker.dto.MarkerResponse.PhotoMarkerResponse;
import marker.dto.MarkerResponse.TalkMarkerResponse;
import marker.dto.PhotoMarkerCreatedRequest;
import marker.dto.TalkMarkerCreatedRequest;
import marker.entity.LossMarker;
import marker.entity.Marker;
import marker.entity.PhotoMarker;
import marker.entity.TalkMarker;
import marker.repository.*;
import marker.service.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarkerService {


    private MarkerRepository markerRepository;
    private LossMarkerRepository lossMarkerRepository;
    private TalkMarkerRepository talkMarkerRepository;
    private PhotoMarkerRepository photoMarkerRepository;
    private TmpUserRepository tmpUserRepository;

    @Autowired
    public MarkerService(MarkerRepository markerRepository, LossMarkerRepository lossMarkerRepository, TalkMarkerRepository talkMarkerRepository, PhotoMarkerRepository photoMarkerRepository, TmpUserRepository tmpUserRepository) {
        this.markerRepository = markerRepository;
        this.lossMarkerRepository = lossMarkerRepository;
        this.talkMarkerRepository = talkMarkerRepository;
        this.photoMarkerRepository = photoMarkerRepository;
        this.tmpUserRepository = tmpUserRepository;
    }



    // Talk Marker를 생성한다.
    public boolean makeTalkMarker(TalkMarkerCreatedRequest talkDto) throws MarkerPointExistsException {
        PointDto point = talkDto.getPoint();
        checkDuplicatePoint(point.getX(), point.getY());
        TalkMarker talkMarker = TalkMarker.builder()
                .user(tmpUserRepository.findById(talkDto.getUser_id()).get())
                .x(talkDto.getPoint().getX())
                .y(talkDto.getPoint().getY())
                .created_datetime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .title(talkDto.getTitle())
                .contents(talkDto.getContents())
                .marker_type("Talk")
                .build();
        talkMarkerRepository.save(talkMarker);
        return true;
    }

    // Photo Marker를 생성한다.
    public boolean makePhotoMarker(PhotoMarkerCreatedRequest photoDto) throws MarkerPointExistsException {
        PointDto point = photoDto.getPoint();
        checkDuplicatePoint(point.getX(), point.getY());
        PhotoMarker photoMarker = PhotoMarker.builder()
                .user(tmpUserRepository.findById(photoDto.getUser_id()).get())
                .x(photoDto.getPoint().getX())
                .y(photoDto.getPoint().getY())
                .created_datetime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .title(photoDto.getTitle())
                .contents(photoDto.getContents())
                .url(photoDto.getUrl())
                .marker_type("Photo")
                .build();
        photoMarkerRepository.save(photoMarker);
        return true;
    }

    // Loss Marker를 생성한다.
    public boolean makeLossMarker(LossMarkerCreatedRequest lossDto) throws MarkerPointExistsException {
        PointDto point = lossDto.getPoint();
        checkDuplicatePoint(point.getX(), point.getY());
        LossMarker lossMarker = LossMarker.builder()
                .user(tmpUserRepository.findById(lossDto.getUser_id()).get())
                .x(lossDto.getPoint().getX())
                .y(lossDto.getPoint().getY())
                .created_datetime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .contents(lossDto.getContents())
                .marker_type("Loss")
                .build();
        lossMarkerRepository.save(lossMarker);
        return true;
    }

    // 생성하려는 마커 좌표(x, y)가 이미 존재하는지 검증한다.
    private void checkDuplicatePoint(int x, int y) throws MarkerPointExistsException {
        if (markerRepository.existsByPoint(x, y).isPresent()){
            throw new MarkerPointExistsException("Marker point is duplicated.");
        }
    }


    public List<MarkerDto> readAllMarkers() {
        List<Marker> markers = markerRepository.findAll();
        return markers.stream().map(x -> x.toDto()).collect(Collectors.toList());
    }

    public List<MarkerDto> readAllTalkMarkers() {
        List<TalkMarker> markers = talkMarkerRepository.findAll();
        return markers.stream().map(x -> x.toDto()).collect(Collectors.toList());
    }

    public List<MarkerDto> readAllLossMarkers() {
        List<LossMarker> markers = lossMarkerRepository.findAll();
        return markers.stream().map(x -> x.toDto()).collect(Collectors.toList());
    }

    public List<MarkerDto> readAllPhotoMarkers() {
        List<PhotoMarker> markers = photoMarkerRepository.findAll();
        return markers.stream().map(x -> x.toDto()).collect(Collectors.toList());
    }

    public LossMarkerResponse getLossMarkerById(int id) {
        LossMarker lossMarker = lossMarkerRepository.findById(id).get();
        return new LossMarkerResponse(lossMarker.getContents(), lossMarker.getCreated_datetime());
    }

    public TalkMarkerResponse getTalkMarkerById(int id) {
        TalkMarker talkMarker = talkMarkerRepository.findById(id).get();
        return new TalkMarkerResponse(talkMarker.getTitle(), talkMarker.getContents(), talkMarker.getCreated_datetime());
    }

    public PhotoMarkerResponse getPhotoMarkerById(int id) {
        PhotoMarker photoMarker = photoMarkerRepository.findById(id).get();
        return new PhotoMarkerResponse(photoMarker.getUrl(), photoMarker.getContents(), photoMarker.getCreated_datetime());
    }
}



