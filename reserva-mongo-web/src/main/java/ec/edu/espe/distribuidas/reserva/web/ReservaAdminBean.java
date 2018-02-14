/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.reserva.web;


import ec.edu.espe.distribuidad.reserva.web.util.FacesUtil;
import ec.edu.espe.distribuidas.reserva.model.Cliente;
import ec.edu.espe.distribuidas.reserva.model.Quinta;
import ec.edu.espe.distribuidas.reserva.model.Reserva;
import ec.edu.espe.distribuidas.reserva.service.ClienteService;
import ec.edu.espe.distribuidas.reserva.service.QuintaService;
import ec.edu.espe.distribuidas.reserva.service.ReservaService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Ing Alvaro Vasquez
 */
@Named
@ViewScoped
public class ReservaAdminBean  extends BaseBean implements Serializable{
    
    private String identificacionBusqueda;
    private List<Cliente> clientes;
    private List<Quinta> listadoQuintas;
    private List<Reserva> listadoReservas;
    private Integer quintaBusqueda;
    
    private boolean enBusquedaPorIdentificacion;
    private boolean enBusquedaPorQuinta;
   
    private Reserva reserva;
    private Cliente cliente;
    private Quinta quinta;
    
    private Reserva reservaSel;
   
    @Inject
    private QuintaService quintaService;
    
    @Inject
    private ClienteService clienteService;
        
    @Inject
    private ReservaService reservaService;
    
    @PostConstruct
    public void init() {
         
        this.listadoReservas = this.reservaService.obtenerTodos();
        this.reserva = new Reserva();
        this.enBusquedaPorIdentificacion = true;        
        this.clientes = this.clienteService.obtenerTodos();
        this.enBusquedaPorQuinta = true;
        this.listadoQuintas = this.quintaService.obtenerTodos();
        
    }

    public List<Reserva> getListadoReservas() {
        return listadoReservas;
    }
        
    @Override
    public void agregar() {
        this.reserva = new Reserva();
        super.agregar();
    }
  
    @Override
    public void modificar() {
        super.modificar();
        this.reserva= new Reserva();
        this.reserva.setCodigo(this.reservaSel.getCodigo());
        this.reserva.setQuinta(this.reservaSel.getQuinta());
        this.reserva.setFechaEmision(this.reservaSel.getFechaEmision());
        this.reserva.setValorFinal(this.reservaSel.getValorFinal());
        
    }
    
    @Override
    public void detalles() {
        super.detalles();
        this.reserva = this.reservaSel;
    }

    public void cancelar() {
        super.reset();
        this.reserva = new Reserva();
    }
    
    
    public void guardar() {
        try {
            if (this.enAgregar) {
                this.reservaService.crear(this.reserva);
                FacesUtil.addMessageInfo("Se agregó la reserva del cliente: " + this.reserva.getCliente().getNombre()+" "+this.reserva.getCliente().getApellido());
            } else {
                this.reservaService.modificar(this.reserva);
                FacesUtil.addMessageInfo("Se modific\u00f3 la reserva del cliente c\u00f3digo: "  + this.reserva.getCliente().getNombre()+" "+this.reserva.getCliente().getApellido());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.reserva = new Reserva();
    }

        
    public String getIdentificacionBusqueda() {
        return identificacionBusqueda;
    }

    public void setIdentificacionBusqueda(String identificacionBusqueda) {
        this.identificacionBusqueda = identificacionBusqueda;
    }

    public Integer getQuintaBusqueda() {
        return quintaBusqueda;
    }

    public void setQuintaBusqueda(Integer quintaBusqueda) {
        this.quintaBusqueda = quintaBusqueda;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Quinta> getListadoQuintas() {
        return listadoQuintas;
    }

    public void setListadoQuintas(List<Quinta> listadoQuintas) {
        this.listadoQuintas = listadoQuintas;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Quinta getQuinta() {
        return quinta;
    }

    public void setQuinta(Quinta quinta) {
        this.quinta = quinta;
    }

    public Reserva getReservaSel() {
        return reservaSel;
    }

    public void setReservaSel(Reserva reservaSel) {
        this.reservaSel = reservaSel;
    }


    
}
