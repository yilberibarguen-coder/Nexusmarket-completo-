# Value Objects y Enumeraciones — NexusMarket

## Enumeraciones acotadas

- `UserStatus`: `ACTIVE`, `BLOCKED`.
- `UserRole`: `BUYER`, `SELLER`, `LOGISTIC_OPERATOR`, `ADMIN`, `SUPERVISOR`, `SUPPORT_AGENT`, `EMPLOYEE`.
- `ProductType`: `PHYSICAL`, `DIGITAL`.
- `ProductStatus`: `PUBLISHED`, `SUSPENDED`, `DISCONTINUED`.
- `MovementType`: `INFLOW`, `RESERVATION`, `SALE`, `ADJUSTMENT`, `RETURN`.
- `InvoiceStatus`: `ISSUED`, `VOIDED`, `REFUNDED`.
- `OperationType`: `CREATE`, `UPDATE`, `STATUS_CHANGE`, `PAYMENT`, `SHIPMENT`, `RETURN`, `REFUND`, `AUTHENTICATION`, `AUDIT`.
- Estados operativos adicionales: `DomainTypes.OrderStatus`, `PaymentStatus`, `ShipmentStatus`.

## Value Objects

- `EmailAddress`: valida el formato básico del correo.
- `Money`: representa cantidades monetarias no negativas y normalizadas a dos decimales.
- `Address`: record inmutable para datos de dirección.
- `CartItem`, `OrderItem` e `InventoryMovement`: records inmutables para líneas y eventos de dominio.

## Regla

Los estados, roles y tipos acotados no se modelan como `String` abiertos en las entidades principales. Los códigos de negocio como SKU, IDs y nombres permanecen como `String` porque son identificadores/texto y no catálogos cerrados.
