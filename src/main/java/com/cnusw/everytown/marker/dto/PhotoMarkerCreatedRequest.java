package marker.dto;

import com.example.demo.dto.PointDto;
import lombok.Getter;

@Getter
public class PhotoMarkerCreatedRequest extends MarkerDto {

    private String title;
    private String contents;
    private String url;


    public PhotoMarkerCreatedRequest(String user_id, PointDto point, String title, String contents, String url) {
        super(user_id, point, "Photo");
        this.title = title;
        this.contents = contents;
        this.url = url;
    }


}
