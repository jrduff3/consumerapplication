package com.booknds.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by criley on 5/6/16.
 */
@Entity
public class Consumer {

    @Id
    @GeneratedValue
    private long id;

    //customer name
    private String consumerName;

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
