package br.com.api.system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractModel {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime criado;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime modificado;
}
