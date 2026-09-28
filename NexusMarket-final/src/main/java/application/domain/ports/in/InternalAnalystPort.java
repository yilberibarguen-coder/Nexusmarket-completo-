package application.domain.ports.in;

/** Role-oriented input port grouping the supported NexusMarket use cases. */
public interface InternalAnalystPort extends
        ConsultCustomerUseCase,
        ConsultCustomerOrdersUseCase,
        ConsultUserUseCase,
        ConsultProductUseCase,
        SearchProductsUseCase,
        ConsultInventoryUseCase,
        ConsultOrderUseCase {}
