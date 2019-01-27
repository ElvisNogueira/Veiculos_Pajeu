package model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Financeiro.class)
public abstract class Financeiro_ {

	public static volatile SingularAttribute<Financeiro, String> observacao;
	public static volatile SingularAttribute<Financeiro, Date> data;
	public static volatile SingularAttribute<Financeiro, Float> valor;
	public static volatile SingularAttribute<Financeiro, Conta> conta;
	public static volatile SingularAttribute<Financeiro, Usuario> usuario;
	public static volatile SingularAttribute<Financeiro, Integer> id;

}

