package com.kt.claudiattorney.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "PRESTATION")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prestation {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "DETAILS")
    private String details;
    @Column(name = "HOURLY_RATE")
    private Double hourlyRate;      //Le taux horaire devrait être par défaut celui associé au dossier, mais avec la possibilité de le modifier pour une prestation exceptionnelle. Je ne sais pas comment traduire ça
    @Column(name = "VAT")
    private Double vat;             //Doit être celle du client. Mais celle du client peut avoir changé (car la loi a changé par ex). Dans ce cas, ça doit modifier la TVA pour les prestations futures sans changer celles passées
    @Column(name = "DATE")
    private Date date;
    @Column(name = "STATUS")
    private PrestationStatus status;
    @Column(name = "BILLABLE_TIME")
    private Double billableTime;                //C'est le temps passé sur une prestation qu'elle pourra officiellement facturer au client. Ca devra être une durée genre 1h30, je ne sais pas quel est le bon type pour ça
    @Column(name = "PRICE_EXCL_VAT")
    private Double priceExcludingVat;           //Ce sera le taux horaire * Durée facturable
    @Column(name = "PRICE_INCL_VAT")
    private Double priceIncludingVat;         //Ce sera PrixHT * TVA
    @Column(name = "WORKING_TIME")
    private Double workingTime;     //C'est la durée qu'elle a vraiment passé sur un dossier, plus longue que la durée facturable, ce sera une info dont elle aura besoin pour voir comment elle a passé sa journée (son emploi du temps)
    @ManyToOne
    @JoinColumn(name = "BILL_ID")
    private Bill bill;
    @ManyToOne
    @JoinColumn(name = "CASE_ID")
    private CourtCase courtCase;
}
