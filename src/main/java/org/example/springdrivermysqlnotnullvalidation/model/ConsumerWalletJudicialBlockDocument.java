package org.example.springdrivermysqlnotnullvalidation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "consumer_wallet_block")
public class ConsumerWalletJudicialBlockDocument {

    @EmbeddedId
    private ConsumerWalletJudicialBlockIdDocument id;

    @Column(name = "consumer_id", nullable = false)
    private Long consumerId;

    @Column(precision = 15, scale = 4, nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private Boolean activated;

    @Column(name = "create_at", nullable = false)
    private LocalDateTime createAt;

    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

    @Column(name = "remaining_amount", precision = 15, scale = 4, nullable = false)
    private BigDecimal remainingAmount;

    public void update(final Boolean activated, final BigDecimal amount, final BigDecimal remainingAmount) {
        this.activated = activated;
        this.amount = amount;
        this.remainingAmount = remainingAmount;
        this.updateAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ConsumerWalletJudicialBlockDocument{" +
            "id=" + id +
            ", consumerId=" + consumerId +
            ", amount=" + amount +
            ", activated=" + activated +
            ", createAt=" + createAt +
            ", updateAt=" + updateAt +
            ", remainingAmount=" + remainingAmount +
            '}';
    }

}
