package le.ac.soagroupwork2.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WCondition {
    @JsonProperty("text")
    private String text;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("code")
    private int code;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
