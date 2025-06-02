package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter //Getter만 있어 변경이 불가능
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() {} //기본생성자 추가(JPA 기술 사용을 위해)

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

}
