
package APITest.Pojo.PlayListAPIRequest;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


public class PlayListAPIRequestBody {

    @JsonProperty("description")
    private String description;
    @JsonProperty("name")
    private String name;
    @JsonProperty("public")
    private Boolean _public;

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("public")
    public Boolean getPublic() {
        return _public;
    }

    @JsonProperty("public")
    public void setPublic(Boolean _public) {
        this._public = _public;
    }

}
