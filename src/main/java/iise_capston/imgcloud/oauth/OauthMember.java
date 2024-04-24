package iise_capston.imgcloud.oauth;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="Users",
uniqueConstraints = {@UniqueConstraint(name="user_unique",columnNames = {"email"}),
})
public class OauthMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Embedded
    private OauthId oauthId;
    private String nickname;
    private String picture;
    @Column
    private String email;

    public Long user_id(){
        return user_id;
    }
    public OauthId oauthId(){
        return oauthId;
    }
    public String nickname(){
        return nickname;
    }
    public String picture(){
        return picture;
    }
    public String email(){
        return email;
    }


}
