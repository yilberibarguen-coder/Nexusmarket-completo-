package application.domain.ports.in;

/** Role-oriented input port grouping the supported NexusMarket use cases. */
public interface BusinessOperatorPort extends
        CreateProductUseCase,
        ConsultProductUseCase,
        UpdateProductUseCase,
        ChangeProductStatusUseCase,
        AssignProductCategoryUseCase,
        CreateCategoryUseCase,
        UpdateCategoryUseCase,
        SearchProductsUseCase,
        CreateInventoryUseCase,
        ConsultInventoryUseCase,
        IncreaseStockUseCase,
        DecreaseStockUseCase,
        ReserveStockUseCase,
        ConsultOrderUseCase,
        UpdateOrderStatusUseCase,
        CreateShipmentUseCase,
        UpdateShipmentStatusUseCase {}
