package com.example.RentRead.RentRedSpringSecurity.Entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="books")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @Column(nullable=false)
    private String title;
    private String author;
    private String genre;
    

   @Enumerated(EnumType.STRING)
    private AvialableStatus availableStatus ; //=AvialableStatus.AVAILABLE;
    
    public enum AvialableStatus
    {
        AVAILABLE,RENTED
    }

}
