package marker.dto;

import com.example.demo.dto.PointDto;
import lombok.Getter;

@Getter
public class TalkMarkerCreatedRequest extends MarkerDto {

    private String title;
    private String contents;

    public TalkMarkerCreatedRequest(String user_id, PointDto point, String title, String contents) {
        super(user_id, point,"Talk");
        this.title = title;
        this.contents = contents;
    }


}
