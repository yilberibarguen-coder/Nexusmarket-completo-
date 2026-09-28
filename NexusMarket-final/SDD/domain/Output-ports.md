# Output Ports

Los 18 Output Ports desacoplan el dominio de persistencia e infraestructura:

1. `AuditLogRepositoryPort`
2. `AuthorizationPort`
3. `CartRepositoryPort`
4. `CategoryRepositoryPort`
5. `CustomerRepositoryPort`
6. `InventoryRepositoryPort`
7. `NotificationPort`
8. `OperationAuditPort`
9. `OrderRepositoryPort`
10. `PasswordServicePort`
11. `PaymentRepositoryPort`
12. `ProductRepositoryPort`
13. `RefundRepositoryPort`
14. `ReturnRequestRepositoryPort`
15. `ShipmentRepositoryPort`
16. `TokenServicePort`
17. `UserRepositoryPort`
18. `WishlistRepositoryPort`

Los adapters concretos implementan estos contratos sin ser importados por las entidades de dominio.
