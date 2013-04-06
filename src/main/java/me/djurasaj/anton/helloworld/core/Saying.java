package me.djurasaj.anton.helloworld.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name="Saying")
public class Saying {
    @JsonProperty
    private long id;

    @JsonProperty
    private String content;

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    private Saying() {
        // deserialize
    }

    public Saying update(Saying saying) {
        this.id = saying.id;
        this.content = saying.content;
        return this;
    }

    @XmlElement
    public long getId() {
        return id;
    }

    @XmlElement
    public String getContent() {
        return content;
    }
}
