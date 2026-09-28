package application.domain.services.catalog;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport;
public class ConsultProductService implements ConsultProductUseCase { private final ProductRepositoryPort products; public ConsultProductService(ProductRepositoryPort p){products=p;} public Product consultProduct(User actor,String id){ServiceSupport.actor(actor);return ServiceSupport.required(products.findById(id),"Product",id);} }
