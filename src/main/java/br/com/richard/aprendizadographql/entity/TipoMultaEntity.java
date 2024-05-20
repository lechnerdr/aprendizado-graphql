package br.com.richard.aprendizadographql.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tipo_multa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class TipoMultaEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    @ToString.Include
    private Long id;

    @ToString.Include
    @Column(name = "codigo", nullable = false)
    private String codigo;

    @ToString.Include
    @Column(name = "descricao", nullable = false)
    private String descricao;

    @ToString.Include
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof TipoMultaEntity other))
            return false;

        return id != null &&
            id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
