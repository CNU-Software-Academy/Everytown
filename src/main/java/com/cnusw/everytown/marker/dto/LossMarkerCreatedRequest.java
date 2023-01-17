package marker.dto;

import com.example.demo.dto.PointDto;
import lombok.Getter;

@Getter
public class LossMarkerCreatedRequest extends MarkerDto {

    private String contents;



    public LossMarkerCreatedRequest(String user_id, PointDto point, String contents) {
        super(user_id, point, "Loss");
        this.contents = contents;
    }


}
