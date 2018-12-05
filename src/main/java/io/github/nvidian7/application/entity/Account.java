package io.github.nvidian7.application.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Accessors(fluent = true)
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @JsonProperty("id")
    private String id;

    @Column
    @JsonProperty("name")
    private String name;

    @Column
    @UpdateTimestamp
    @JsonProperty("update_dtm")
    private LocalDateTime updateDtm;

    @Builder
    private Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
