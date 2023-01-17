package marker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@SuperBuilder
@AllArgsConstructor
@DiscriminatorValue("Talk")
@NoArgsConstructor
@ToString
@Getter
public class TalkMarker extends Marker {

    @Column
    private String title;

    @Column
    private String contents;


    public TalkMarker(TmpUser user, int x, int y, LocalDateTime created_datetime, String title, String contents) {
        super(user, x, y, created_datetime, "Talk");
        this.title = title;
        this.contents = contents;
    }
}
