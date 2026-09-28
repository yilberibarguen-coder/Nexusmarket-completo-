package application.domain.ports.in;

/** Role-oriented input port grouping the supported NexusMarket use cases. */
public interface BusinessCustomerPort extends
        ConsultProductUseCase,
        SearchProductsUseCase,
        CreateCartUseCase,
        AddProductToCartUseCase,
        RemoveProductFromCartUseCase,
        ClearCartUseCase,
        ManageWishlistUseCase,
        ManageCustomerAddressesUseCase,
        CreateOrderUseCase,
        ConsultOrderUseCase,
        ConsultCustomerOrdersUseCase,
        CalculateOrderTotalUseCase,
        RegisterPaymentUseCase,
        ConfirmOrderUseCase,
        CancelOrderUseCase,
        RequestReturnUseCase {}
