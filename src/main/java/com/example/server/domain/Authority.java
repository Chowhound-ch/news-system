package com.example.server.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 权限实体
 */
@Entity
@Data
@NoArgsConstructor
public class Authority implements GrantedAuthority{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Authority(Integer id, String name) {
        this.name = name;
    }

    static List<Authority> getAuthority(Integer type){

        List<Authority> res=new ArrayList<>();
        String []roles={"","ROLE_USER","ROLE_USER_S","ROLE_ADMIN"};
        if (type==3){
            type=1;
        }else if (type==2){
            type=2;
        }else {
            type=3;
        }
        for (int i = 1; i <= type ; i++) {
            res.add(new Authority(i,roles[i]));
        }
        return res;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
