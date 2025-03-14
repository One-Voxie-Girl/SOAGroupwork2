package le.ac.soagroupwork2.Entity.RouteAdapter;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Step {
    @JsonProperty("instruction")
    private Instruction instruction;

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }
}
