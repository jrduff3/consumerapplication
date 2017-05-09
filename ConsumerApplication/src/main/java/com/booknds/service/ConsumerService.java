package com.booknds.service;

import com.booknds.domain.Consumer;
import com.booknds.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by criley on 5/6/16.
 */
@Service
public class ConsumerService {

    private ConsumerRepository consumerRepository;

    @Autowired
    public ConsumerService(ConsumerRepository consumerRepository){this.consumerRepository = consumerRepository;}


    public Consumer getConsumerById(long id){return consumerRepository.findOne(id);}

    public Iterable<Consumer> getAllConsumers(){return consumerRepository.findAll();}

    public void saveConsumer(Consumer consumer){consumerRepository.save(consumer);}

    public List<Consumer> getConsumerByName(String consumerName){return consumerRepository.findAllConsumerByConsumerName(consumerName); }

    public void deleteConsumer(long id){consumerRepository.delete(id);}


}
