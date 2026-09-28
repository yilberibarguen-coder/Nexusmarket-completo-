package application.domain.ports.in;

/** Role-oriented input port grouping the supported NexusMarket use cases. */
public interface CommercialEmployeePort extends
        CreateProductUseCase,
        ConsultProductUseCase,
        UpdateProductUseCase,
        ChangeProductStatusUseCase,
        AssignProductCategoryUseCase,
        CreateCategoryUseCase,
        UpdateCategoryUseCase,
        SearchProductsUseCase,
        ConsultOrderUseCase,
        UpdateOrderStatusUseCase {}
