package com.angular.fullstack.config;

import com.angular.fullstack.entity.Country;
import com.angular.fullstack.entity.Product;
import com.angular.fullstack.entity.ProductCategory;
import com.angular.fullstack.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class dataRestConfig implements RepositoryRestConfigurer {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        HttpMethod[] unsupportedAction={HttpMethod.DELETE,HttpMethod.PUT,HttpMethod.POST};
       //disabled Htttp Mehod for delete,put and post
        disabledHttpMethod(Product.class,config,unsupportedAction);
        disabledHttpMethod(ProductCategory.class,config, unsupportedAction);
        disabledHttpMethod(Country.class,config,unsupportedAction);
        disabledHttpMethod(State.class,config,unsupportedAction);

        //expose the id for easy extraction and master view
        exposeId(config);
    }

    private void disabledHttpMethod(Class theClass,RepositoryRestConfiguration config, HttpMethod[] unsupportedAction) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedAction))
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedAction));
    }

    private void exposeId(RepositoryRestConfiguration config) {

        Set<EntityType<?>> entities=entityManager.getMetamodel().getEntities();

        List<Class> entityClass=new ArrayList<>();

        for(EntityType tempEntityType: entities){

            entityClass.add(tempEntityType.getJavaType());

        }

        Class[] domainTypes=entityClass.toArray(new Class[0]);

        config.exposeIdsFor(domainTypes);

    }
}
