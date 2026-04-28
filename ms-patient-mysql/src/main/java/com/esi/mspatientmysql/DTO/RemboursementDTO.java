package com.esi.mspatientmysql.DTO;

import java.time.LocalDate;

public record RemboursementDTO(Double montant, LocalDate dateRemboursement) {
}
