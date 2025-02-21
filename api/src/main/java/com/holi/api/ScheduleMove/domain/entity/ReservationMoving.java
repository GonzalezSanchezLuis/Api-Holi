package com.holi.api.ScheduleMove.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.holi.api.utils.LocalDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.holi.api.drivers.domain.entity.Driver;
import com.holi.api.users.domain.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "reservation_moving")
public class ReservationMoving {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationMovingId;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime reservedAt;

    @NotNull
    private String moveType;

    @NotNull
    private String origin;
    @NotNull
    private String destination;

    @NotNull
    private BigDecimal originLat;

    @NotNull
    private BigDecimal originLng;

    @NotNull
    private BigDecimal destinationLat;

    @NotNull
    private BigDecimal destinationLng;

    @NotNull
    private String ReservationStatus;

    @NotNull
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "driverId")
    private Driver driver;

    @Override
    public String toString() {
        return "ReservationMoving{" +
                "reservationMovingId=" + reservationMovingId +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", status='" + ReservationStatus + '\'' +
                // Omitir las relaciones de User y Driver
                '}';
    }



}
