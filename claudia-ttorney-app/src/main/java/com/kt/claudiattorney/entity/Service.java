package com.kt.claudiattorney.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity(name = "SERVICE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "DETAILS")
    private String details;

    @Column(name = "HOURLY_RATE")
    private Double hourlyRate;

    // le taux horaire devrait être par défaut celui associé au dossier, mais avec la possibilité
    // de le modifier pour une prestation exceptionnelle. Je ne sais pas comment traduire ça

    @Column(name = "TVA")
    private Double tva;

    // Doit être celle du client. Mais celle du client peut avoir changé (car la loi a changé par ex)
    // Dans ce cas, ça doit modifier la TVA pour les prestations futures sans changer celles passées
    // Je ne sais pas comment traduire ça non plus

    @Column(name = "DATE")
    private Date date;

    @Column(name = "STATUS")
    private ServiceStatus status;

    @Column(name = "FACT_DURATION")
    private Double factDuration;
    //C'est le temps passé sur une prestation qu'elle pourra officiellement facturer au client
    //Ca devra être une durée genre 1h30, je ne sais pas quel est le bon type pour ça

    @Column(name = "PRIX_HT")
    private Double prixHT;
    //Ce sera le taux horaire * Durée facturable

    @Column(name = "PRIX_TTC")
    private Double prixTTC;
    //Ce sera PrixHT * TVA

    @Column(name = "REAL_DURATION")
    private Double realDuration;
    //C'est la durée qu'elle a vraiment passé sur un dossier, plus longue que la durée facturable, ce
    //sera une info dont elle aura besoin pour voir comment elle a passé sa journée (son emploi du temps)

    @ManyToOne
    private Bill bill;
}
