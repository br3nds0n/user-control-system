package br.com.api.system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractModel {

    private LocalDateTime criado;
    private LocalDateTime modificado;
}
