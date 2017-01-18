package com.kt.claudiattorney.entity;

import com.google.common.collect.Lists;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "CUSTOMER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "FIRST_NAME")
//    @NotEmpty(message = "First name cannot be null !")
    private String firstName;
    @Column(name = "LAST_NAME")
//    @NotEmpty(message = "Last name cannot be null !")
    private String lastName;
    @Column(name = "ADDRESS")
//    @NotEmpty(message = "Address name cannot be null !")
    private String address;
    @Column(name = "PHONE_NUMBER")
//    @NotEmpty(message = "Phone number cannot be null !")
    private String phoneNumber;
    @Column(name = "MAIL")
//    @NotEmpty(message = "mail cannot be null !")
    private String mail;
    @Column(name = "OTHER")
    private String other;
    @Column(name = "VAT")
//    @NotNull(message = "VAT cannot be null !")
    private Double vat;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CUSTOMER_CASE", joinColumns = @JoinColumn(name = "CUSTOMER_ID"), inverseJoinColumns = @JoinColumn(name = "CASE_ID"))
    private List<Case> cases;

    public List<Case> getCases() {
        if (cases == null) {
            cases = Lists.newArrayList();
        }
        return cases;
    }
}
