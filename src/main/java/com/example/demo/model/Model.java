package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
public class Model {
    @Column(name = "status",nullable = false)
    private Boolean status;

    @Column(name = "created_date",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date createDate;


    @Column(name = "created_by",nullable = false)
    private String createdBy;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    private Date modifiedDate;

}
