package com.booknds.controller;

import com.booknds.domain.Consumer;
import com.booknds.service.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Created by criley on 5/6/16.
 */
@RestController
public class ConsumerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private ConsumerService consumerService;

    @Autowired
    public ConsumerController(ConsumerService consumerService){this.consumerService = consumerService;}

    /*@RequestMapping(value = "/consumers/{name}", method= RequestMethod.GET )
    public List<Consumer> getConsumerByName(@PathVariable(value="name") String consumerName){
        logger.info("In method getConsumerByName, consumer value is: " + consumerName);
        return consumerService.getConsumerByName(consumerName);
    }*/

    @CrossOrigin
    @RequestMapping(value = "/consumers", method = RequestMethod.GET)
    public Iterable<Consumer> getAllConsumers() {
        logger.info("In method getAllConsumers");
        return consumerService.getAllConsumers();
    }

    //@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/consumers/{id}", method= RequestMethod.GET )
    public Consumer getConsumer(@PathVariable(value="id") long id){
        logger.info("In method getConsumer, id value is: " + id);
        return consumerService.getConsumerById(id);
    }


    //@CrossOrigin(origins = "http://localhost:3000")
    @CrossOrigin
    @RequestMapping(value = "/consumers", method = RequestMethod.POST)
    public void createConsumer(@RequestBody() Consumer request){
        logger.info("In method createConsumer");
        if(request.getConsumerName().equals(null) || request.getConsumerName().equals("")){
            logger.info("Request with null data received.");
        }
        else {
            consumerService.saveConsumer(request);
        }

    }

    @CrossOrigin
    //@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/consumers", method = RequestMethod.PUT)
    public void updateConsumer(@RequestBody() Consumer request){
        logger.info("In method updateConsumer");
        if(request.getConsumerName().equals(null) || request.getConsumerName().equals("")){
            logger.info("Request with null data received.");
        }
        else {
            consumerService.saveConsumer(request);
        }
    }

    @CrossOrigin
    //@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/consumers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteConsumer(@PathVariable(value="id") long id){
        logger.info("In method deleteConsumer");
        HttpHeaders headers = new HttpHeaders();
        consumerService.deleteConsumer(id);
        headers.add("Access-Control-Allow-Origin","*");
        return new ResponseEntity(headers, HttpStatus.OK);

    }

    @CrossOrigin
    @RequestMapping(value = "/consumers/{id}", method = RequestMethod.OPTIONS)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity getConsumerOptions(HttpSession session) {
        logger.info("In method getConsumerOptions=");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Allow","GET,POST,PUT,DELETE,OPTIONS");
        headers.add("Access-Control-Allow-Origin","*");
        return new ResponseEntity(headers, HttpStatus.OK);

    }


}
