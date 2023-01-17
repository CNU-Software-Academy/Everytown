package marker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 구현을 위해 임시로 User 대신 만들어둔 TmpUser 입니다.

@Entity
@Getter
@NoArgsConstructor
public class TmpUser {
    @Id
    private String id;
    @Column
    private String pw;
    @Column
    private String name;
    @Column
    private String nickname;

    @Column
    private String email;

    public TmpUser(String id, String pw, String name, String nickname, String email) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.nickname = nickname;
    }
}
