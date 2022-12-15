package be.pxl.prismaservice.domain.request.traject.groeipunten.mentale_functies.socio_emotionele_ontwikkeling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormSocioEmotioneleOntwikkelingRequest {
    private boolean persoonlijkheid;
}
