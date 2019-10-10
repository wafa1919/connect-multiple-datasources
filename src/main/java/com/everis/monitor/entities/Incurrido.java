package com.everis.monitor.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Immutable
@Data
@NoArgsConstructor
@Subselect("SELECT * FROM FENIX_REP.REPORT_INCURRIDO WHERE NRO_EMPLEADO=134567")
@Table(name = "REPORT_INCURRIDO", schema = "FENIX_REP")
public class Incurrido {
	
	@Column(name = "PERSONA")
	private String persona;
	
	@Id
	@Column(name = "NRO_EMPLEADO")
	private Long nroEmpleado;
	
	@Column(name = "FACTORIA")
	private String factoria;
	
	@Column(name = "LINEA")
	private String linea;
	
	@Column(name = "CELDA")
	private String CELDA;
	
	@Column(name = "ID_PET")
	private String idPet;
	
	@Column(name = "DESC_PET")
	private String descPet;
	
	@Column(name = "TIPO_PET")
	private String tipoPet;
	
	@Column(name = "ID_OT")
	private String idOt;
	
	@Column(name = "DESC_OT")
	private String descOt;
	
	@Column(name = "LINEA_OT")
	private String lineaOt;
	
	@Column(name = "CELDA_OT")
	private String celdaOt;
	
	@Column(name = "DESC_TAREA")
	private String descTarea;
	
	@Column(name = "SUBTAREA_ESTIMADOR")
	private String substareaEstimador;
	
	@Column(name = "COMENTARIO_TAREA")
	private String comentarioTarea;
	
	@Column(name = "ESFUERZO")
	private String esfuerzo;
	
	@Column(name = "HORAS_INCURRIDAS")
	private String horsIncurridas;
	
	@Column(name = "ETC")
	private String etc;
	
	@Column(name = "TEXTOAUX2")
	private String textoAux2;
	
	@Column(name = "FECHA")
	private String fecha;
	
	@Column(name = "NOMBRE_TIPO_TAREA")
	private String nombreTipoTarea;
	
	@Column(name = "COD_TS_MAD")
	private String codTsMad;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "ESFUERZO_MONTO")
	private String esfuerzoMonto;
	
	@Column(name = "CONCEPTO_DISPONIBLE")
	private String conceptoDisponible;
	
	@Column(name = "APLICACION")
	private String applicacion;
	
	@Column(name = "SUBTIPO_DISPONIBILIDAD")
	private String subtipoDisponibilidad;
	
	@Column(name = "DESCRIPCION_TIPO_DISP")
	private String descripcionTipoDisp;
	
	@Column(name = "DESCRIPCION_SUBTIPO_DISP")
	private String descripcionSubtipoDisp;
	
	@Column(name = "FECHA_AUX")
	private String fechaAux;

}
