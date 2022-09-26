package br.com.api.system.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractModelDTO {

    private LocalDateTime criado;
    private LocalDateTime modificado;
}
