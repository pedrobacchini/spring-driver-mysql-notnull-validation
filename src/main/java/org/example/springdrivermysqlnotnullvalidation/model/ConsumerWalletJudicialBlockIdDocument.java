package org.example.springdrivermysqlnotnullvalidation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerWalletJudicialBlockIdDocument implements Serializable {

    @Column(name = "judicial_block_id", nullable = false)
    private Long judicialBlockId;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "owner", nullable = false)
    private OwnerTypeEnum ownerType;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ConsumerWalletJudicialBlockIdDocument)) {
            return false;
        }
        final ConsumerWalletJudicialBlockIdDocument that = (ConsumerWalletJudicialBlockIdDocument) o;
        return Objects.equals(judicialBlockId, that.judicialBlockId) &&
            ownerType == that.ownerType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(judicialBlockId, ownerType);
    }

}
