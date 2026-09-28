# Servicios de Dominio — NexusMarket

El catálogo implementa exactamente los 42 servicios originales. Cada servicio implementa un Input Port individual y encapsula reglas de negocio; `ServiceSupport` es una utilidad compartida y no es un servicio del catálogo.

## Catálogo por módulo

### Customer
1. `RegisterCustomerService`
2. `ConsultCustomerService`
3. `UpdateCustomerService`
4. `ChangeCustomerStatusService`
5. `ManageCustomerAddressesService`
6. `ConsultCustomerOrdersService`

### Authentication
7. `RegisterCustomerUserService`
8. `RegisterEmployeeUserService`
9. `LoginService`
10. `LogoutService`
11. `ConsultUserService`
12. `ChangeUserStatusService`

### Catalog
13. `CreateProductService`
14. `ConsultProductService`
15. `UpdateProductService`
16. `ChangeProductStatusService`
17. `AssignProductCategoryService`
18. `CreateCategoryService`
19. `UpdateCategoryService`
20. `SearchProductsService`

### Inventory
21. `CreateInventoryService`
22. `ConsultInventoryService`
23. `IncreaseStockService`
24. `DecreaseStockService`
25. `ReserveStockService`

### Cart
26. `CreateCartService`
27. `AddProductToCartService`
28. `RemoveProductFromCartService`
29. `ClearCartService`
30. `ManageWishlistService`

### Order
31. `CreateOrderService`
32. `ConsultOrderService`
33. `ConfirmOrderService`
34. `CancelOrderService`
35. `RegisterPaymentService`
36. `UpdateOrderStatusService`
37. `CalculateOrderTotalService`

### Fulfillment
38. `CreateShipmentService`
39. `UpdateShipmentStatusService`
40. `RequestReturnService`
41. `ApproveReturnService`
42. `ProcessRefundService`

## Regla de conteo
`ServiceSupport.java` no es un caso de uso ni un servicio de negocio; solo centraliza validaciones repetidas. Por tanto, el proyecto contiene **42 servicios + 1 utilidad de soporte**.
