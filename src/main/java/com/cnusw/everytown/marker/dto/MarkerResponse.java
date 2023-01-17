package marker.dto;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


// static 멤버 클래스를 이용하여 DTO 관리하기
// ㄴ> 하나의 도메인에서 여러 DTO가 나오는 경우 다음과 같은 중첩클래스를 두는 구조로 관리할 수 있다.
// ㄴ> 참고한 링크 : https://velog.io/@gudnr1451/Spring-Boot-%EC%A0%95%EC%A0%81-%EB%A9%A4%EB%B2%84-%ED%81%B4%EB%9E%98%EC%8A%A4%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%98%EC%97%AC-DTO-%EA%B4%80%EB%A6%AC%ED%95%98%EA%B8%B0


public class MarkerResponse{

    public static String timeFormat = "yyyy-MM-dd";


    @Getter
    public static class LossMarkerResponse {
        private String contents;

        private String created_datetime;

        public LossMarkerResponse(String contents, LocalDateTime createdDatetime) {
            this.contents = contents;
            this.created_datetime = createdDatetime.format(DateTimeFormatter.ofPattern(timeFormat));
        }
    }

    @Getter
    public static class PhotoMarkerResponse {

        private String url;
        private String contents;
        private String localDateTime;

        public PhotoMarkerResponse(String url, String contents, LocalDateTime localDateTime) {
            this.url = url;
            this.contents = contents;
            this.localDateTime = localDateTime.format(DateTimeFormatter.ofPattern(timeFormat));
        }
    }

    @Getter
    public static class TalkMarkerResponse {

        private String title;
        private String contents;
        private String created_datetime;

        public TalkMarkerResponse(String title, String contents, LocalDateTime created_datetime) {
            this.title = title;
            this.contents = contents;
            this.created_datetime = created_datetime.format(DateTimeFormatter.ofPattern(timeFormat));
        }
    }
}