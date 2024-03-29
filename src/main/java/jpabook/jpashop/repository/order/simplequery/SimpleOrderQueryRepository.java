package jpabook.jpashop.repository.order.simplequery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SimpleOrderQueryRepository {

    private final EntityManager em;

    public List<SimpleOrderQueryDto> findOrderDtos() {
        return em.createQuery(
                        "select new jpabook.jpashop.repository.order.simplequery.SimpleOrderQueryDto(o.id, o.member.name, o.orderDate, o.status, o.delivery.address)" +
                                " from Order o" +
                                " join o.member m" +
                                " join o.delivery d", SimpleOrderQueryDto.class)
                .getResultList();
    }
}
