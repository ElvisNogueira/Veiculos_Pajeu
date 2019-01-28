package model;

import java.sql.Date;
import java.sql.Time;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Reserva.class)
public abstract class Reserva_ {

	public static volatile SingularAttribute<Reserva, String> tipo_locacao;
	public static volatile SingularAttribute<Reserva, Integer> duracao_estimada;
	public static volatile SingularAttribute<Reserva, Time> hora_retirada;
	public static volatile SingularAttribute<Reserva, Cliente> cliente;
	public static volatile SingularAttribute<Reserva, Categoria> categoria;
	public static volatile SingularAttribute<Reserva, Integer> id;
	public static volatile SingularAttribute<Reserva, Date> data_retirada;
	public static volatile SingularAttribute<Reserva, Float> valor_entrada;

}

