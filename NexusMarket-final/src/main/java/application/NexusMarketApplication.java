package application;
import application.adapters.authorization.RoleAuthorizationAdapter;
import application.adapters.persistence.inmemory.*;
import application.adapters.security.*;
import application.adapters.useCases.*;
import application.domain.ports.out.*;
import application.domain.services.authentication.*;
import application.domain.services.cart.*;
import application.domain.services.catalog.*;
import application.domain.services.customer.*;
import application.domain.services.fulfillment.*;
import application.domain.services.inventory.*;
import application.domain.services.order.*;

/**
 * Manual composition root for the academic project.
 * Concrete adapters are created here and injected into domain services through ports.
 */
public final class NexusMarketApplication {
    public final CustomerRepositoryPort customers = new InMemoryCustomerAdapter();
    public final UserRepositoryPort users = new InMemoryUserAdapter();
    public final ProductRepositoryPort products = new InMemoryProductAdapter();
    public final CategoryRepositoryPort categories = new InMemoryCategoryAdapter();
    public final InventoryRepositoryPort inventories = new InMemoryInventoryAdapter();
    public final CartRepositoryPort carts = new InMemoryCartAdapter();
    public final WishlistRepositoryPort wishlists = new InMemoryWishlistAdapter();
    public final OrderRepositoryPort orders = new InMemoryOrderAdapter();
    public final PaymentRepositoryPort payments = new InMemoryPaymentAdapter();
    public final ShipmentRepositoryPort shipments = new InMemoryShipmentAdapter();
    public final ReturnRequestRepositoryPort returns = new InMemoryReturnRequestAdapter();
    public final RefundRepositoryPort refunds = new InMemoryRefundAdapter();
    public final InMemoryAuditAdapter audit = new InMemoryAuditAdapter();
    public final PasswordServicePort passwords = new InMemoryPasswordAdapter();
    public final InMemoryTokenAdapter tokens = new InMemoryTokenAdapter();
    public final JwtTokenAdapter jwtTokens = new JwtTokenAdapter("NexusMarket-academic-secret-2026");
    public final AuthorizationPort authorization = new RoleAuthorizationAdapter();

    public final RegisterCustomerService registerCustomer = new RegisterCustomerService(customers,audit,authorization);
    public final ConsultCustomerService consultCustomer = new ConsultCustomerService(customers);
    public final UpdateCustomerService updateCustomer = new UpdateCustomerService(customers,audit);
    public final ChangeCustomerStatusService changeCustomerStatus = new ChangeCustomerStatusService(customers,audit,authorization);
    public final ManageCustomerAddressesService manageCustomerAddresses = new ManageCustomerAddressesService(customers,audit);
    public final ConsultCustomerOrdersService consultCustomerOrders = new ConsultCustomerOrdersService(customers,orders);

    public final RegisterCustomerUserService registerCustomerUser = new RegisterCustomerUserService(users,customers,passwords,audit);
    public final RegisterEmployeeUserService registerEmployeeUser = new RegisterEmployeeUserService(users,passwords,audit);
    public final LoginService login = new LoginService(users,passwords,jwtTokens);
    public final LogoutService logout = new LogoutService(jwtTokens);
    public final ConsultUserService consultUser = new ConsultUserService(users);
    public final ChangeUserStatusService changeUserStatus = new ChangeUserStatusService(users,audit);

    public final CreateProductService createProduct = new CreateProductService(products,audit,authorization);
    public final ConsultProductService consultProduct = new ConsultProductService(products);
    public final UpdateProductService updateProduct = new UpdateProductService(products,audit);
    public final ChangeProductStatusService changeProductStatus = new ChangeProductStatusService(products,audit);
    public final AssignProductCategoryService assignProductCategory = new AssignProductCategoryService(products,categories,audit);
    public final CreateCategoryService createCategory = new CreateCategoryService(categories,audit);
    public final UpdateCategoryService updateCategory = new UpdateCategoryService(categories,audit);
    public final SearchProductsService searchProducts = new SearchProductsService(products);

    public final CreateInventoryService createInventory = new CreateInventoryService(inventories,products,audit);
    public final ConsultInventoryService consultInventory = new ConsultInventoryService(inventories,products);
    public final IncreaseStockService increaseStock = new IncreaseStockService(inventories,products,audit);
    public final DecreaseStockService decreaseStock = new DecreaseStockService(inventories,products,audit);
    public final ReserveStockService reserveStock = new ReserveStockService(inventories,products,audit);

    public final CreateCartService createCart = new CreateCartService(carts,audit);
    public final AddProductToCartService addProductToCart = new AddProductToCartService(carts,customers,products,inventories,audit);
    public final RemoveProductFromCartService removeProductFromCart = new RemoveProductFromCartService(carts,customers,audit);
    public final ClearCartService clearCart = new ClearCartService(carts,customers,audit);
    public final ManageWishlistService manageWishlist = new ManageWishlistService(wishlists,customers,audit);

    public final CreateOrderService createOrder = new CreateOrderService(customers,carts,inventories,orders,audit);
    public final ConsultOrderService consultOrder = new ConsultOrderService(orders);
    public final ConfirmOrderService confirmOrder = new ConfirmOrderService(orders,payments,audit);
    public final CancelOrderService cancelOrder = new CancelOrderService(orders,inventories,audit);
    public final RegisterPaymentService registerPayment = new RegisterPaymentService(orders,payments,audit);
    public final UpdateOrderStatusService updateOrderStatus = new UpdateOrderStatusService(orders,audit);
    public final CalculateOrderTotalService calculateOrderTotal = new CalculateOrderTotalService(orders);

    public final CreateShipmentService createShipment = new CreateShipmentService(orders,shipments,audit);
    public final UpdateShipmentStatusService updateShipmentStatus = new UpdateShipmentStatusService(shipments,orders,audit);
    public final RequestReturnService requestReturn = new RequestReturnService(orders,returns,audit);
    public final ApproveReturnService approveReturn = new ApproveReturnService(returns,orders,audit);
    public final ProcessRefundService processRefund = new ProcessRefundService(returns,refunds,orders,audit);

    // Role-oriented Input Port adapters.
    public final PublicAccessUseCaseAdapter publicAccess = new PublicAccessUseCaseAdapter(this);
    public final NaturalCustomerUseCaseAdapter naturalCustomer = new NaturalCustomerUseCaseAdapter(this);
    public final BusinessCustomerUseCaseAdapter businessCustomer = new BusinessCustomerUseCaseAdapter(this);
    public final BusinessOperatorUseCaseAdapter businessOperator = new BusinessOperatorUseCaseAdapter(this);
    public final BusinessSupervisorUseCaseAdapter businessSupervisor = new BusinessSupervisorUseCaseAdapter(this);
    public final TellerEmployeeUseCaseAdapter tellerEmployee = new TellerEmployeeUseCaseAdapter(this);
    public final CommercialEmployeeUseCaseAdapter commercialEmployee = new CommercialEmployeeUseCaseAdapter(this);
    public final InternalAnalystUseCaseAdapter internalAnalyst = new InternalAnalystUseCaseAdapter(this);
}
