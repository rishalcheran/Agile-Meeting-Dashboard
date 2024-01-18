package net.javaguides.amd.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notes")
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Title", nullable = false, unique = true)
    private String title;

    @Column(name = "Notes")
    private String notes;

    @Column(name = "Date")
    private String date;

    @Column(name = "Time")
    private String time;

    @Column(name = "User") // Assuming this field corresponds to the user associated with the notes
    private String user;
}
