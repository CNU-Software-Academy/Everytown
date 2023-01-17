package marker.dto;

import com.example.demo.dto.PointDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MarkerDto {

    protected final String user_id;
    protected final PointDto point;
    protected final String type;

}