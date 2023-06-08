package com.example.EntranceIntern.Order;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.EntranceIntern.User.User;

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
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Float totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // create date and update time
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "update_update")
    private LocalDateTime updateDate;

    public void setOrderItems(List<OrderItem> orderItemList) {
    }

    @Override
    public String toString() {
        return "Order [createDate=" + createDate + ", id=" + id + ", totalPrice=" + totalPrice + ", updateDate="
                + updateDate + ", userId=" + (user != null ? user.getId() : null) + ", username="
                + (user != null ? user.getUsername() : null) + "]";
    }

}
