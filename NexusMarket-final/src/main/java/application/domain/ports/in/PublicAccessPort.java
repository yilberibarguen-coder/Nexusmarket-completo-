package application.domain.ports.in;

/** Role-oriented input port grouping the supported NexusMarket use cases. */
public interface PublicAccessPort extends
        LoginUseCase,
        RegisterCustomerUseCase,
        ConsultProductUseCase,
        SearchProductsUseCase {}
