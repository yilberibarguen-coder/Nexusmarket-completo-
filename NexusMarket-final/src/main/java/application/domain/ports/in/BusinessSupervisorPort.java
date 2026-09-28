package application.domain.ports.in;

/** Role-oriented input port grouping the supported NexusMarket use cases. */
public interface BusinessSupervisorPort extends
        ConsultCustomerUseCase,
        ConsultCustomerOrdersUseCase,
        ConsultUserUseCase,
        ConsultProductUseCase,
        ConsultInventoryUseCase,
        ConsultOrderUseCase,
        ChangeCustomerStatusUseCase,
        ChangeUserStatusUseCase,
        ChangeProductStatusUseCase,
        ApproveReturnUseCase,
        ProcessRefundUseCase,
        SearchProductsUseCase {}
