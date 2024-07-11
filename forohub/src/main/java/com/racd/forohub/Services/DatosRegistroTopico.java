package com.racd.forohub.Services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DatosRegistroTopico {
    private String titulo;
    private String mensaje;
    private Long autorId;
    private Long cursoId;
}
