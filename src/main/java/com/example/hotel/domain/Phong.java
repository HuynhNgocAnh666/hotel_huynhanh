package com.example.hotel.domain;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_phong")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Phong {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_phong", nullable = false, unique = true)
    private Long maPhong;

    @Column(name = "ten_phong", nullable = false)
    private String tenPhong;

    @Column(name = "gia_phong", nullable = false)
    private Double giaPhong;

    @Column(name = "dia_chi", nullable = false)
    private String diaChi;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "tinh_trang_phong", nullable = false)
    private String tinhTrangPhong;

    @ManyToOne
    @JoinColumn(name = "ma_loai")
    private LoaiPhong loaiPhong;

    @OneToMany(mappedBy = "phong", cascade = CascadeType.REMOVE)
    private Set<BookingRoom> bookingRooms;

    public Phong(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Phong{" +
                "id=" + id +
                ", maPhong=" + maPhong +
                ", tenPhong='" + tenPhong + '\'' +
                ", giaPhong=" + giaPhong +
                ", diaChi='" + diaChi + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", tinhTrangPhong='" + tinhTrangPhong + '\'' +
                '}';
    }
}
