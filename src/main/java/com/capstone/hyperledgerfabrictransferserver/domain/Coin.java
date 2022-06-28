package com.capstone.hyperledgerfabrictransferserver.domain;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COIN_ID")
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Column(name = "DELETED")
    private boolean deleted;

    public static Coin of(String coinName){
        return new Coin(coinName, false);
    }

    private Coin(String name, boolean deleted) {
        this.name = name;
        this.deleted = deleted;
    }

    public void setDeleted(){
        this.name = name + id;
        this.deleted = true;
    }
}
