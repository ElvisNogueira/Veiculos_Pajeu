package model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Motorista.class)
public abstract class Motorista_ {

	public static volatile SingularAttribute<Motorista, Date> data_venc_habilitacao;
	public static volatile SingularAttribute<Motorista, Integer> id;
	public static volatile SingularAttribute<Motorista, String> num_habilitacao;
	public static volatile SingularAttribute<Motorista, Pessoa_Fisica> pessoa_Fisica;

}

