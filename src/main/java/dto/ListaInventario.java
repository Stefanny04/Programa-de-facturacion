
package dto;

public class ListaInventario {
    
    private Integer existencias;
    private Integer codigo;
    private String nombreP;
    private Long valorUnit;

    public Integer getExistencias() {
        return existencias;
    }

    public void setExistencias(Integer existencias) {
        this.existencias = existencias;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
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
    
    @Override
    public String toString(){
        return this.existencias+" "+
                this.codigo +" "+
                this.nombreP+" "+
                this.valorUnit;
    }
}
