package org.stc.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private BigInteger id;
    private String name;
    private String grade;
    private String crag;
    private String state;
    private String style;
    private String url;
    private String type;

    public Route(){}
    public Route(BigInteger id, String name, String grade, String crag, String state, String style, String url, String type) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.crag = crag;
        this.state = state;
        this.style = style;
        this.url = url;
        this.type = type;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCrag() {
        return crag;
    }

    public void setCrag(String crag) {
        this.crag = crag;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
