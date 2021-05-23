
package dto;


public class Producto{
    
    private String codigo;
    private String nombreP;
    private Long valorUnit;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public Long getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(Long valorUnit) {
        this.valorUnit = valorUnit;
    }
    
    public Producto() {
    }

    public Producto(String codigo, String nombreP, Long valorUnit) {
        this.codigo = codigo;
        this.nombreP = nombreP;
        this.valorUnit = valorUnit;
    }
    
}
