package com.example.hotel.domain;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_loai_phong")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LoaiPhong {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_loai", nullable = false, unique = true)
    private String maLoai;

    @Column(name = "ten_loai_phong", nullable = false)
    private String tenLoaiPhong;

    @OneToMany(mappedBy = "loaiPhong")
    private Set<Phong> phongs;

    public LoaiPhong(Long id) {
        this.id = id;
    }
}
