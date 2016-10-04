package com.pocstudentproject.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "objectId",
        "fotoUrl",
        "idade",
        "nome",
        "telefone",
        "updatedAt",
        "createdAt",
        "endereco"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Student {

    @JsonProperty("objectId")
    private String objectId;
    @JsonProperty("fotoUrl")
    private String fotoUrl;
    @JsonProperty("idade")
    private Integer idade;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("telefone")
    private String telefone;
    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("endereco")
    private String endereco;

    /**
     * @return The objectId
     */
    @JsonProperty("objectId")
    public String getObjectId() {
        return objectId;
    }

    /**
     * @param objectId The objectId
     */
    @JsonProperty("objectId")
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    /**
     * @return The fotoUrl
     */
    @JsonProperty("fotoUrl")
    public String getFotoUrl() {
        return fotoUrl;
    }

    /**
     * @param fotoUrl The fotoUrl
     */
    @JsonProperty("fotoUrl")
    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    /**
     * @return The idade
     */
    @JsonProperty("idade")
    public Integer getIdade() {
        return idade;
    }

    /**
     * @param idade The idade
     */
    @JsonProperty("idade")
    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    /**
     * @return The nome
     */
    @JsonProperty("nome")
    public String getNome() {
        return nome;
    }

    /**
     * @param nome The nome
     */
    @JsonProperty("nome")
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return The telefone
     */
    @JsonProperty("telefone")
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone The telefone
     */
    @JsonProperty("telefone")
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return The updatedAt
     */
    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt The updatedAt
     */
    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return The createdAt
     */
    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt The createdAt
     */
    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return The endereco
     */
    @JsonProperty("endereco")
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco The endereco
     */
    @JsonProperty("endereco")
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}