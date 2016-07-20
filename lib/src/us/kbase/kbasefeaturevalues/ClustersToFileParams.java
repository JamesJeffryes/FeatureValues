
package us.kbase.kbasefeaturevalues;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * <p>Original spec-file type: ClustersToFileParams</p>
 * <pre>
 * format - optional field, can be one of "TSV" or "SIF" ("TSV" is default value).
 * </pre>
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "input_ref",
    "to_shock",
    "file_path",
    "format"
})
public class ClustersToFileParams {

    @JsonProperty("input_ref")
    private String inputRef;
    @JsonProperty("to_shock")
    private Long toShock;
    @JsonProperty("file_path")
    private String filePath;
    @JsonProperty("format")
    private String format;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("input_ref")
    public String getInputRef() {
        return inputRef;
    }

    @JsonProperty("input_ref")
    public void setInputRef(String inputRef) {
        this.inputRef = inputRef;
    }

    public ClustersToFileParams withInputRef(String inputRef) {
        this.inputRef = inputRef;
        return this;
    }

    @JsonProperty("to_shock")
    public Long getToShock() {
        return toShock;
    }

    @JsonProperty("to_shock")
    public void setToShock(Long toShock) {
        this.toShock = toShock;
    }

    public ClustersToFileParams withToShock(Long toShock) {
        this.toShock = toShock;
        return this;
    }

    @JsonProperty("file_path")
    public String getFilePath() {
        return filePath;
    }

    @JsonProperty("file_path")
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ClustersToFileParams withFilePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    public ClustersToFileParams withFormat(String format) {
        this.format = format;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return ((((((((((("ClustersToFileParams"+" [inputRef=")+ inputRef)+", toShock=")+ toShock)+", filePath=")+ filePath)+", format=")+ format)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
