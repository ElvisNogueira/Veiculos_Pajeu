package model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pessoa_Fisica.class)
public abstract class Pessoa_Fisica_ extends model.Cliente_ {

	public static volatile SingularAttribute<Pessoa_Fisica, String> cpf;
	public static volatile SingularAttribute<Pessoa_Fisica, Date> data_nasc;
	public static volatile SingularAttribute<Pessoa_Fisica, String> sexo;

}

