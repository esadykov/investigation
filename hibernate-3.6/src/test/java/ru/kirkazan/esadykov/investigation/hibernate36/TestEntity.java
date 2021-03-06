package ru.kirkazan.esadykov.investigation.hibernate36;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.UUID;

/**
 * @author ser
 * @since 19.02.14 22:44
 */
@Entity
@Table(name = "version")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
//@Cacheable
public class TestEntity {
    @Id
    @Column( columnDefinition = "UUID not null primary key")
    private UUID id;

    @Column(columnDefinition = "UUID not null" )
    private UUID entityId;

    @Column
    private String value;
    public TestEntity() {
    }

    @PrePersist
    private void prePersist() {
        if (id == null)
            id = UUID.randomUUID();
        if (entityId == null)
            entityId = id;
    }

    public TestEntity(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public UUID getEntityId() {
        return entityId;
    }

    public void setEntityId(UUID entityId) {
        this.entityId = entityId;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
