package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable // 내장타입
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;
}
