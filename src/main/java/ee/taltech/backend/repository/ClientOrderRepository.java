package ee.taltech.backend.repository;

import ee.taltech.backend.model.order.ClientOrder;
import ee.taltech.backend.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientOrderRepository extends JpaRepository<ClientOrder, Long> {

    List<ClientOrder> findByUser(User user);
}
