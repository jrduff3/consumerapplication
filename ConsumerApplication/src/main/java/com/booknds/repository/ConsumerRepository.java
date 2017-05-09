package com.booknds.repository;

import com.booknds.domain.Consumer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by criley on 5/6/16.
 */
public interface ConsumerRepository extends CrudRepository <Consumer,Long>{

    List<Consumer> findAllConsumerByConsumerName(String consumerName);


}
