package com.bs23.rabbit.model;

import lombok.*;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;

/**
 * @author Ahmed Dinar
 * Created 1/3/2021
 */

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class FundTransfer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  @NonNull
  private Long amount;

  @Column
  @NonNull
  private String fromAccount;

  @Column
  @NonNull
  private String toAccount;
}
