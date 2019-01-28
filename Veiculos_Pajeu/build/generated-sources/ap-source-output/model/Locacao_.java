package model;

import java.sql.Date;
import java.sql.Time;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Locacao.class)
public abstract class Locacao_ {

	public static volatile SingularAttribute<Locacao, Veiculo> veiculo;
	public static volatile SingularAttribute<Locacao, Time> hora_retirada;
	public static volatile SingularAttribute<Locacao, Integer> duracao_estiimada;
	public static volatile SingularAttribute<Locacao, Float> km_inicial;
	public static volatile SingularAttribute<Locacao, Float> valor_locacao;
	public static volatile SingularAttribute<Locacao, Float> km_final;
	public static volatile SingularAttribute<Locacao, Date> data_devolucao;
	public static volatile SingularAttribute<Locacao, Date> data_retirada;
	public static volatile SingularAttribute<Locacao, String> tipo_locacao;
	public static volatile SingularAttribute<Locacao, Cliente> cliente;
	public static volatile SingularAttribute<Locacao, Time> hora_devolucao;
	public static volatile SingularAttribute<Locacao, Motorista> motorista;
	public static volatile SingularAttribute<Locacao, Float> taxa_combuustivel;
	public static volatile SingularAttribute<Locacao, Float> taxa_higienizacao;
	public static volatile SingularAttribute<Locacao, Integer> id;
	public static volatile SingularAttribute<Locacao, Reserva> reserva;
	public static volatile SingularAttribute<Locacao, String> status;

}

