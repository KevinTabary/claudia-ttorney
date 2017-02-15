package com.kt.claudiattorney.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.google.common.collect.Lists;
import com.kt.claudiattorney.util.JsonUtils;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "CUSTOMER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "MAIL")
    private String mail;
    @Column(name = "OTHER")
    private String other;
    @Column(name = "VAT")
    private Double vat;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CUSTOMER_CASE", joinColumns = @JoinColumn(name = "CUSTOMER_ID"), inverseJoinColumns = @JoinColumn(name = "CASE_ID"))
    private List<CourtCase> courtCases;

    public List<CourtCase> getCourtCases() {
        if (courtCases == null) {
            courtCases = Lists.newArrayList();
        }
        return courtCases;
    }

    @Override
    public String toString() {
        return JsonUtils.stringify(this);
    }
}
