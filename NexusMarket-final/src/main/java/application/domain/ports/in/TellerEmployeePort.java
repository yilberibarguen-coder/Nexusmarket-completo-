package application.domain.ports.in;

/** Role-oriented input port grouping the supported NexusMarket use cases. */
public interface TellerEmployeePort extends
        ConsultCustomerUseCase,
        ConsultOrderUseCase,
        RegisterPaymentUseCase,
        UpdateOrderStatusUseCase,
        CreateShipmentUseCase,
        UpdateShipmentStatusUseCase,
        ApproveReturnUseCase,
        ProcessRefundUseCase {}
