
package datafileutil;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * <p>Original spec-file type: ShockToFileParams</p>
 * <pre>
 * Input for the shock_to_file function.
 * Required parameters:
 * shock_id - the ID of the Shock node.
 * file_path - the location to save the file output. If this is a
 *     directory, the file will be named as per the filename in Shock.
 * Optional parameters:
 * unpack - if the file is compressed and / or a file bundle, it will be
 *     decompressed and unbundled into the directory containing the
 *     original output file. unpack supports gzip, bzip2, tar, and zip
 *     files. Default false. Currently unsupported.
 * </pre>
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "shock_id",
    "file_path",
    "unpack"
})
public class ShockToFileParams {

    @JsonProperty("shock_id")
    private String shockId;
    @JsonProperty("file_path")
    private String filePath;
    @JsonProperty("unpack")
    private Long unpack;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("shock_id")
    public String getShockId() {
        return shockId;
    }

    @JsonProperty("shock_id")
    public void setShockId(String shockId) {
        this.shockId = shockId;
    }

    public ShockToFileParams withShockId(String shockId) {
        this.shockId = shockId;
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

    public ShockToFileParams withFilePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    @JsonProperty("unpack")
    public Long getUnpack() {
        return unpack;
    }

    @JsonProperty("unpack")
    public void setUnpack(Long unpack) {
        this.unpack = unpack;
    }

    public ShockToFileParams withUnpack(Long unpack) {
        this.unpack = unpack;
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
        return ((((((((("ShockToFileParams"+" [shockId=")+ shockId)+", filePath=")+ filePath)+", unpack=")+ unpack)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
