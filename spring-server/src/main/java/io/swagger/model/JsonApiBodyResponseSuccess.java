package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * JsonApiBodyResponseSuccess
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-02T15:28:49.618Z")

public class JsonApiBodyResponseSuccess   {
  @JsonProperty("id_negocio")
  private String idNegocio = null;

  @JsonProperty("nombre_empresa")
  private String nombreEmpresa = null;

  @JsonProperty("tipo_negocio")
  private String tipoNegocio = null;

  public JsonApiBodyResponseSuccess idNegocio(String idNegocio) {
    this.idNegocio = idNegocio;
    return this;
  }

  /**
   * Get idNegocio
   * @return idNegocio
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getIdNegocio() {
    return idNegocio;
  }

  public void setIdNegocio(String idNegocio) {
    this.idNegocio = idNegocio;
  }

  public JsonApiBodyResponseSuccess nombreEmpresa(String nombreEmpresa) {
    this.nombreEmpresa = nombreEmpresa;
    return this;
  }

  /**
   * Get nombreEmpresa
   * @return nombreEmpresa
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getNombreEmpresa() {
    return nombreEmpresa;
  }

  public void setNombreEmpresa(String nombreEmpresa) {
    this.nombreEmpresa = nombreEmpresa;
  }

  public JsonApiBodyResponseSuccess tipoNegocio(String tipoNegocio) {
    this.tipoNegocio = tipoNegocio;
    return this;
  }

  /**
   * Get tipoNegocio
   * @return tipoNegocio
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getTipoNegocio() {
    return tipoNegocio;
  }

  public void setTipoNegocio(String tipoNegocio) {
    this.tipoNegocio = tipoNegocio;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonApiBodyResponseSuccess jsonApiBodyResponseSuccess = (JsonApiBodyResponseSuccess) o;
    return Objects.equals(this.idNegocio, jsonApiBodyResponseSuccess.idNegocio) &&
        Objects.equals(this.nombreEmpresa, jsonApiBodyResponseSuccess.nombreEmpresa) &&
        Objects.equals(this.tipoNegocio, jsonApiBodyResponseSuccess.tipoNegocio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idNegocio, nombreEmpresa, tipoNegocio);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonApiBodyResponseSuccess {\n");
    
    sb.append("    idNegocio: ").append(toIndentedString(idNegocio)).append("\n");
    sb.append("    nombreEmpresa: ").append(toIndentedString(nombreEmpresa)).append("\n");
    sb.append("    tipoNegocio: ").append(toIndentedString(tipoNegocio)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

