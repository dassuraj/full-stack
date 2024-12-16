/*
package com.edigitalnepal.sms.base;

import com.edigitalnepal.sms.models.others.Team;
import com.edigitalnepal.sms.models.school.SchoolAccount;
import com.edigitalnepal.sms.util.Strings;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructorpublic
public class ModelLazy {
    @Id
    @GeneratedValue
    private Long id;
    @JsonFormat(pattern = Strings.DATE_TIME_PATTERN,timezone = Strings.TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false, name = "created_date")
    private Date createdDate;
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, updatable = false, name = "created_by")
    private SchoolAccount createdBy;
    @JsonFormat(pattern = Strings.DATE_TIME_PATTERN, timezone = Strings.TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false, name = "modified_date")
    private Date modifiedDate;
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(insertable = false, name = "modified_by")
    private SchoolAccount modifiedBy;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, updatable = false, name = "team_id")
    private Team team;
}*/
