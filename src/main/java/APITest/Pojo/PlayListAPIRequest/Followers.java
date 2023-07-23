
package APITest.Pojo.PlayListAPIRequest;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;



public class Followers {

    @JsonProperty("href")
    private Object href;
    @JsonProperty("total")
    private Integer total;

    @JsonProperty("href")
    public Object getHref() {
        return href;
    }

    @JsonProperty("href")
    public void setHref(Object href) {
        this.href = href;
    }

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

}
