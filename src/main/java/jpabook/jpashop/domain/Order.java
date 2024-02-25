package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name="order_id")
    private Long id;

    // 2. 모든 연관관계는 지연로딩으로 설정
    // - 즉시로딩(EAGER)은 예측이 어렵고, 어떤 sql이 실행될지 추적이 어렵움
    // - @ManyToOne(fetch = FetchType.LAZY)로 정의
    @ManyToOne(fetch = FetchType.LAZY) // 지연로딩
    @JoinColumn(name="member_id")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate; // 주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // 주문상태 [ORDER, CANCEL]

    // == 연관관계 메서드 == : 양방향일때 씀 //
    // 3. 컬렉선은 필드에서 초기화
    // - null 문제에서 안전
    // - 필드에서 초기화하지 않으면 하이버네이트 내부 메커니즘에 문제가 발생할 수 있음
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }
}
