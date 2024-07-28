package com.example.hotel.domain;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_dich_vu")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DichVu {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "madv", unique = true, nullable = false)
    private String maDV;

    @Column(name = "tendv", nullable = false)
    private String tenDV;

    @Column(name = "giadv", nullable = false)
    private Double giaDV;

    @ManyToMany
    @JoinTable(name = "tbl_booking_room_dich_vu", joinColumns = @JoinColumn(name = "dich_vu_id"), inverseJoinColumns = @JoinColumn(name = "booking_room_id"))
    private Set<BookingRoom> bookingRooms;

    public DichVu(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DichVu{" +
                "giaDV=" + giaDV +
                ", tenDV='" + tenDV + '\'' +
                ", maDV='" + maDV + '\'' +
                ", id=" + id +
                '}';
    }
}
