package com.demo.profilematcher.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long playerId;
    @Column(name = "credential")
    private String credential;
    @Column(name = "created")
    private LocalDateTime created;
    @Column(name = "modified")
    private LocalDateTime modified;
    @Column(name = "last_session")
    private LocalDateTime lastSession;
    @Column(name = "total_spent")
    private BigDecimal totalSpent;
    @Column(name = "total_refund")
    private BigDecimal totalRefund;
    @Column(name = "total_transactions")
    private int totalTransactions;
    @Column(name = "last_purchase")
    private LocalDateTime lastPurchase;
    @Column(name = "activeCampaigns")
    @ElementCollection(targetClass = String.class)
    private List<String> activeCampaigns;

    @JsonManagedReference
    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Device> devices;
    @Column(name = "level")
    private int level;
    @Column(name = "xp")
    private int xp;
    @Column(name = "total_playtime")
    private int totalPlaytime;
    @Column(name = "country")
    private String country;
    @Column(name = "language")
    private String language;
    @Column(name = "birthdate")
    private LocalDateTime birthdate;
    @Column(name = "gender")
    private String gender;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "Item",
            joinColumns = {@JoinColumn(name = "id", referencedColumnName = "item_id")})
    @MapKeyColumn(name = "name")
    @Column(name = "count")
    private Map<String, Integer> inventory;

    @Transient
    private Clan clan;
    @Column(name = "item_id")
    private Long itemId;
    @Column(name = "device_id")
    private Long deviceId;

}
