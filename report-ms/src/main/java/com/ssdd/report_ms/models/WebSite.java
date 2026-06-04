package com.ssdd.report_ms.models;


import lombok.Data;

import java.io.Serializable;

//@Table(name = "web_site")
@Data
public class WebSite implements Serializable {
    private Long id;
    private String name;
    private Category category;
    private String description;
}
