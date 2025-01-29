package com.example.RentRead.RentRedSpringSecurity.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="rentalRead")
@Entity
@Builder
public class RentalRead
{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long rentid;
    @ManyToOne
    private User user;
    @ManyToOne
    private Book book;
   private boolean isReturned;
   


    // public enum StatusRental {
    //     ACTIVE, RETURNED
        
    // }
}