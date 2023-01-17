package marker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@SuperBuilder
@AllArgsConstructor
@DiscriminatorValue("Loss")
@NoArgsConstructor
@Getter
public class LossMarker extends Marker{

    @Column
    private String contents;

    public LossMarker(TmpUser user, int x, int y, LocalDateTime created_datetime, String contents) {
        super(user, x, y, created_datetime, "Loss");
        this.contents = contents;
    }
}
