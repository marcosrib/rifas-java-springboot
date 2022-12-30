package com.rifas.trevorifas.adapters.outbound.repositories.entity;

import com.rifas.trevorifas.application.core.domain.enums.EnumStatus;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
@Where(clause = "status =  ACTIVATED")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", length = 100, nullable = false)
  private String name;

  @Column(name = "username", length = 100, nullable = false)
  private String username;


  @Column(name = "email", length = 100, nullable = false, unique = true)
  private String email;

  @Column(name = "password", nullable = false)
  private String password;
  @Column(name = "status")
  @Enumerated(value = EnumType.STRING)
  private EnumStatus status;
  @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
  private Set<RaffleEntity> raffles;

  @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
  @JoinTable(name = "user_profiles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "profile_id"))
  private Set<ProfileEntity> profiles;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updated_at;

  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;

  @PrePersist
  public void prePersist() {
    createdAt = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate() {
    updated_at = LocalDateTime.now();
  }

}
