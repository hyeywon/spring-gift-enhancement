package gift.api.option;

import gift.api.option.domain.Option;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findAllByProductId(Long id);
}
