package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Veiculo.class)
public abstract class Veiculo_ {

	public static volatile SingularAttribute<Veiculo, Integer> num_passageiros;
	public static volatile SingularAttribute<Veiculo, Integer> ano_fabricacao;
	public static volatile SingularAttribute<Veiculo, String> numChassi;
	public static volatile SingularAttribute<Veiculo, String> cor;
	public static volatile SingularAttribute<Veiculo, Categoria> categoria;
	public static volatile SingularAttribute<Veiculo, String> modelo;
	public static volatile SingularAttribute<Veiculo, Locadora> locadora;
	public static volatile SingularAttribute<Veiculo, String> num_motor;
	public static volatile SingularAttribute<Veiculo, Integer> num_portas;
	public static volatile SingularAttribute<Veiculo, Integer> ano_modelo;
	public static volatile SingularAttribute<Veiculo, Integer> id;
	public static volatile SingularAttribute<Veiculo, String> fabricante;
	public static volatile SingularAttribute<Veiculo, String> tipo_combuustivel;
	public static volatile SingularAttribute<Veiculo, Float> torqe_motor;
	public static volatile SingularAttribute<Veiculo, Float> km_atual;
	public static volatile SingularAttribute<Veiculo, String> placa;

}

