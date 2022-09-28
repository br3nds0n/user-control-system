package br.com.api.system.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractModelDTO {

    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime criado;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime modificado;
}
