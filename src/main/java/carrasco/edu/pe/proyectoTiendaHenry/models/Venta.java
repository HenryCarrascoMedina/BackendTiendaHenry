package carrasco.edu.pe.proyectoTiendaHenry.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @Column(name = "id_venta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;
    @Column(name = "fecha_venta")
    private LocalDateTime fechaVenta;
    private Double subtotal;
    private Double igv;
    private Double total;
    private Boolean estado;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;
    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;
    @ManyToOne
    @JoinColumn(name = "id_metodo_pago")
    private MetodoPago metodoPago;

    public Venta() {
    }

    public Venta(Integer idVenta, LocalDateTime fechaVenta, Double subtotal, Double igv, Double total, Boolean estado, Cliente cliente, Empleado empleado, Sucursal sucursal, MetodoPago metodoPago) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.estado = estado;
        this.cliente = cliente;
        this.empleado = empleado;
        this.sucursal = sucursal;
        this.metodoPago = metodoPago;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    @PrePersist
    public void prePersist() {
        this.fechaVenta = LocalDateTime.now();
    }
    
}
